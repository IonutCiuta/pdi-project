package pdi.smartfarming.tools;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pdi.smartfarming.dto.Notification;
import pdi.smartfarming.dto.Plant;

/**
 * ionutciuta24@gmail.com on 20.05.2017.
 */

public class Data {

    public static List<Notification> getNotifications() {
        List<Notification> notifications = new ArrayList<>();

        for(int i = 0; i < 5; i ++) {
            notifications.add(new Notification(
                    "100", "Plant " + i,
                    i * 1100 + i + "",
                    i * 1200 + i + "",
                    i * 1300 + i + "",
                    new Date()
            ));
        }

        return notifications;
    }

    public static List<Plant> getPlants() {
        List<Plant> plants = new ArrayList<>();

        for(int i = 0; i < 5; i ++) {
            plants.add(new Plant(
                    "Plant " + i,
                    "Normal conditions",
                    new Date()));
        }

        return plants;
    }
}
