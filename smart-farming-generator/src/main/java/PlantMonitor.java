import java.io.IOException;

import static java.lang.Thread.sleep;

/**
 * Created by gevlad on 17-May-17.
 */

public abstract class PlantMonitor implements Runnable{
    protected String name;
    protected Long delay;

    public PlantMonitor(String name, Long delay) {
        this.name = name;
        this.delay = delay;
    }

    @Override
    public void run() {
        System.out.println("Client planta: " + this.getName() + "... a pornit");

        try {
            while(true) {
                generate();
                sleep(5000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public abstract void generate() throws IOException, InterruptedException;


    public String getName() {
        return name;
    }
}