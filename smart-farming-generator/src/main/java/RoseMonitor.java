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
public class RoseMonitor extends PlantMonitor {
    private static int id = 3;
    private Set<Sensor> sensors;


    public RoseMonitor(String name, Long delay) {
        super("rose-" + id++, delay);
        this.sensors = new HashSet<>();
    }

    @Override
    public void  generate() throws IOException, InterruptedException {
        Sensor sensorOne = new Sensor(HUMIDITY, 945);
        Sensor sensorTwo = new Sensor(LIGHT, 345);
        Sensor sensorThree = new Sensor(TEMPERATURE, 105);

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

        Iterator<Sensor> it = sensors.iterator();

        for (;it.hasNext();) {
            Sensor sensor = it.next();
            byte[] message = new String(sensor.getType().toString() + ": " + sensor.getValue() + " ").getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(message);
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
