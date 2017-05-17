import com.pdi.smart.farming.commons.Sensor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gevlad on 17-May-17.
 */
public class TomatoMonitor extends VegetableMonitor {
    private static int id = 1;
    private final double lightInc   = 0.01d;
    private final double tempInc    = 0.01d;
    private final double humInc     = 0.01d;


    public TomatoMonitor(String name, Long delay) {
        super("tomato-" + id++, delay);
    }

    @Override
    public Map<Sensor, Double> generate() {
        Map<Sensor, Double> measurement = new HashMap<>();

        return measurement;
    }
}
