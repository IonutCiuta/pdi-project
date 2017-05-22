package com.pdi.smart.farming.fcm;

import com.pdi.smart.farming.rest.dto.Notification;
import com.pdi.smart.farming.rest.dto.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertTrue;

/**
 * ionutciuta24@gmail.com on 21.05.2017.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class FCMTest {

    @Autowired
    public FcmService fcmService;

    /*@Test
    public void test_succes() {
        String to = "deALFAZOzzo:APA91bELuEBql-RbsV8LThIIjL19BwfZQkroJCU7V925IIcRqY0BKVQ6dyT4LqxCqgTC-LiH7T-Xbh7aZDogMqxKxDiWL3uiDDp6vcDb6DNvG09ZvutLba4x1U5PiE4sQce0CGkEhSCA";

        FirebaseNotification fcmNotification = new FirebaseNotification("Warning", "One of your plant is in danger!");
        FirebaseData fcmData = new FirebaseData("p1", "Plant 1","1200", "1333", "5000", new Date(), "Ok");
        FirebaseMessage fcmMessage = new FirebaseMessage(fcmNotification, fcmData, to);
        //fcmService.push(fcmMessage, new User("ion", "333", "asasd"));
    }*/

    @Test
    public void test_data_processing() {
        String data = "p1 humidity:430 light:950 temperature:1025";
        assertTrue(fcmService.getHumidity(data).equals("430"));
        assertTrue(fcmService.getLight(data).equals("950"));
        assertTrue(fcmService.getTemperature(data).equals("1025"));
        fcmService.processData(data);
    }
}
