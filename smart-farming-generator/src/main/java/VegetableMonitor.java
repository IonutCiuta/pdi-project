import java.io.IOException;

import static java.lang.Thread.sleep;

/**
 * ionutciuta24@gmail.com on 03.05.2017.
 */

public abstract class VegetableMonitor implements Runnable{

    protected String name;
    protected Long delay;

    public VegetableMonitor(String name, Long delay) {
        this.name = name;
        this.delay = delay;
    }

    @Override
    public void run() {

        System.out.println("Vegetable client: " + this.getName() + " is on");

        try {
            while(true) {
                System.out.println();
                generate();
                sleep(delay);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public abstract void generate() throws IOException, InterruptedException;

    public String getName() {
        return name;
    }
}
