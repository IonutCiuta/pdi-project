import java.io.IOException;

import static java.lang.Thread.sleep;

/**
 * Created by gevlad on 20-May-17.
 */
public class Client {

    public static void main(String args[]){

        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        TomatoMonitor tomato = new TomatoMonitor("Rosie", (long)5000, 101);
        CucumberMonitor cucumber = new CucumberMonitor("Castravete", (long)5000, 102);
        RoseMonitor rose = new RoseMonitor("Trandafir", (long)5000, 103);

        TomatoMonitor tomato2 = new TomatoMonitor("Rosie", (long)5000, 201);
        CucumberMonitor cucumber2 = new CucumberMonitor("Castravete", (long)5000, 202);
        RoseMonitor rose2 = new RoseMonitor("Trandafir", (long)5000, 203);


        Thread clientTomato = new Thread(tomato);
        Thread clientCucumber = new Thread(cucumber);
        Thread clientRose = new Thread(rose);

        Thread clientTomato2 = new Thread(tomato2);
        Thread clientCucumber2 = new Thread(cucumber2);
        Thread clientRose2 = new Thread(rose2);

        clientTomato.start();
        clientCucumber.start();
        clientRose.start();


        clientTomato2.start();
        clientCucumber2.start();
        clientRose2.start();

    }
}
