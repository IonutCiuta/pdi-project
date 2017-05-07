import com.pdi.smart.farming.commons.Sensor;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ionutciuta24@gmail.com on 03.05.2017.
 */
public abstract class PlantMonitor implements Runnable{
    protected String name;
    protected Long delay;
    protected Set<Sensor> sensors;

    public PlantMonitor(String name, Long delay) {
        this.name = name;
        this.delay = delay;
        this.sensors = new HashSet<>();
    }

    @Override
    public void run() {
        generate();

        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public abstract Map<Sensor, Double> generate();

    public void addSensor(Sensor sensor) {
        this.sensors.add(sensor);
    }

    public Set<Sensor> getSensors() {
        return sensors;
    }

    public String getName() {
        return name;
    }
}
