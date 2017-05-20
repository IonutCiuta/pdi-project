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
 * Created by gevlad on 17-May-17.
 */
public class TomatoMonitor extends VegetableMonitor {
    private static int id = 1;
    private Set<Sensor> sensors;


    public TomatoMonitor(String name, Long delay) {
        super("tomato-" + id++, delay);
        this.sensors = new HashSet<>();
    }

    @Override
    public void generate() throws IOException, InterruptedException{
        RandomGenerator r = new RandomGenerator(500, 1499);

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

        Iterator<Sensor> it = sensors.iterator();
        Sensor sensor;
        for (;it.hasNext();) {
            sensor = it.next();
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
