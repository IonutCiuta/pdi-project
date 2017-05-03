import com.pdi.smart.farming.commons.Sensor;

import java.util.HashMap;
import java.util.Map;

/**
 * ionutciuta24@gmail.com on 03.05.2017.
 */
public class RoseMonitor extends PlantMonitor {
    private static int id = 1;

    public RoseMonitor(String name, Long delay) {
        super("rose-" + id++, delay);
    }

    @Override
    public Map<Sensor, Double> generate() {
        Map<Sensor, Double> measurement = new HashMap<>();
        return measurement;
    }
}