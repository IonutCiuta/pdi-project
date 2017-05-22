package com.pdi.smart.farming.fcm;

import com.pdi.smart.farming.commons.AlertValues;
import com.pdi.smart.farming.db.FirebaseMessageRepository;
import com.pdi.smart.farming.db.PlantRepository;
import com.pdi.smart.farming.db.UserRepository;
import com.pdi.smart.farming.rest.dto.Notification;
import com.pdi.smart.farming.rest.dto.Plant;
import com.pdi.smart.farming.rest.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import sun.rmi.runtime.Log;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * ionutciuta24@gmail.com on 27.04.2017.
 */
@Component
public class FcmService {
    private final Logger log = LoggerFactory.getLogger(getClass().getName());

    @Value("${fcm.server.key}")
    private String fcmServerKey;

    @Value("${fcm.api.url}")
    private String fcmApiUrl;

    @Autowired
    private PlantRepository plantRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FirebaseMessageRepository firebaseMessageRepository;

    private RestTemplate restTemplate;

    @PostConstruct
    private void init() {
        this.restTemplate = new RestTemplate();
    }

    private void push(FirebaseMessage notification) {
        log.info("Sending {}", notification);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("Authorization", "key=" + fcmServerKey);
        HttpEntity<FirebaseMessage> entity = new HttpEntity<>(notification, httpHeaders);
        restTemplate.exchange(fcmApiUrl, HttpMethod.POST, entity, Object.class);
    }

    public void processData(String data) {
        String plantId = data.split(" ")[0];
        Plant plant = plantRepository.findOne(plantId);
        User user = userRepository.findOne(plant.getUserId());

        FirebaseData fcmData = new FirebaseData(
                plantId, plant.getName(),
                getHumidity(data),
                getTemperature(data),
                getLight(data),
                new Date(),
                convertData(data));

        FirebaseNotification fcmNotification = new FirebaseNotification(
                "Warning for " + plant.getName(), convertData(data));

        FirebaseMessage notification = new FirebaseMessage(fcmNotification, fcmData, null);

        user.getDevicesIds().forEach(id -> {
                    notification.setTo(id);
                    push(notification);
                    firebaseMessageRepository.save(notification);
                }
        );
    }

    public String getHumidity(String data) {
        String splitMessage[] = data.split(" ");
        String humidity = splitMessage[1];
        String splitHumidity[] = humidity.split(":");
        return splitHumidity[1];
    }

    public String getLight(String data) {
        String splitMessage[] = data.split(" ");
        String light = splitMessage[2];
        String splitLight[] = light.split(":");
        return splitLight[1];
    }

    public String getTemperature(String data) {
        String splitMessage[] = data.split(" ");
        String temperature = splitMessage[3];
        String splitTemperature[] = temperature.split(":");
        return splitTemperature[1];
    }

    public String convertData(String data) {
        int humidityValue       = new Integer(getHumidity(data));
        int lightValue          = new Integer(getLight(data));
        int temperatureValue    = new Integer(getTemperature(data));

        String body = null;
        if (humidityValue < AlertValues.minValueHumidity)
            body = "Plant/Vegetable has low humidity!";
        if (humidityValue > AlertValues.maxValueHumidity)
            body = "Plant/Vegetable has high humidity!";
        if (lightValue < AlertValues.minValueLight)
            body = "Plant/Vegetable has low light!";
        if (lightValue > AlertValues.maxValueLight)
            body = "Plant/Vegetable has high light!";
        if (temperatureValue < AlertValues.minValueTemperature)
            body = "Plant/Vegetable has low temperature!";
        if (temperatureValue > AlertValues.maxValueTemperature)
            body = "Plant/Vegetable has high temperature!";
        else {
            body = "Plant/Vegetable has optimal conditions!";
        }

        return body;
    }
}
