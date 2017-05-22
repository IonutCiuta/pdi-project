import com.pdi.smart.farming.commons.Sensor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.*;

import static com.pdi.smart.farming.commons.Sensor.Type.HUMIDITY;
import static com.pdi.smart.farming.commons.Sensor.Type.LIGHT;
import static com.pdi.smart.farming.commons.Sensor.Type.TEMPERATURE;

/**
 * ionutciuta24@gmail.com on 03.05.2017.
 */
public class RoseMonitor extends Monitor {
    private Set<Sensor> sensors;


    public RoseMonitor(String name, Long delay, int id) {
        super("rose-" + id, delay, id);
        this.sensors = new HashSet<>();
    }

    @Override
    public void  generate() throws IOException, InterruptedException {
        RandomGenerator r = new RandomGenerator(500, 1498);

        Sensor sensorOne = new Sensor(HUMIDITY, r.getNumber());
        Sensor sensorTwo = new Sensor(LIGHT, r.getNumber());
        Sensor sensorThree = new Sensor(TEMPERATURE, r.getNumber());

        this.sensors.clear();
        this.addSensor(sensorOne);
        this.addSensor(sensorTwo);
        this.addSensor(sensorThree);

        InetSocketAddress hostAddress = new InetSocketAddress("localhost", 8090);
        SocketChannel client = null;
        try {
            client = SocketChannel.open(hostAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] id = new String(String.valueOf(super.id + " ")).getBytes();
        ByteBuffer bufferID = ByteBuffer.wrap(id);
        client.write(bufferID);
        bufferID.clear();

        Iterator<Sensor> it = sensors.iterator();

        Sensor sensor;
        ByteBuffer buffer;
        for (;it.hasNext();) {
            sensor = it.next();
            byte[] message = new String(sensor.getType().toString() + ":" + sensor.getValue() + " ").getBytes();
            buffer  = ByteBuffer.wrap(message);
            client.write(buffer);
            buffer.clear();
        }

        client.close();
    }
    public void addSensor(Sensor sensor) {
        this.sensors.add(sensor);
    }

    public Set<Sensor> getSensors() {
        return sensors;
    }
}
