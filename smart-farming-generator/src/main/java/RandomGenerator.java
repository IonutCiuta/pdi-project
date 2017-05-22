import java.util.Random;

/**
 * Created by gevlad on 19-May-17.
 */
public class RandomGenerator {

    private int minValue;
    private int maxValue;

    public RandomGenerator(int minValue, int maxValue){
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public int getNumber(){
        Random r = new Random();
        return r.nextInt(maxValue-minValue) + minValue ;
    }
}
