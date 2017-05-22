package com.pdi.smart.farming.fcm;

import com.pdi.smart.farming.commons.AlertValues;
import com.pdi.smart.farming.db.UserRepository;
import com.pdi.smart.farming.rest.dto.Notification;
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

    private RestTemplate restTemplate;

    @PostConstruct
    private void init() {
        this.restTemplate = new RestTemplate();
    }


    public void push(FirebaseMessage notification) {
        log.info("Sending {}", notification);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("Authorization", "key=" + fcmServerKey);
        HttpEntity<FirebaseMessage> entity = new HttpEntity<>(notification, httpHeaders);
        restTemplate.exchange(fcmApiUrl, HttpMethod.POST, entity, Object.class);
    }

    public FirebaseMessage convertData(String data) {

        String splitMessage[] = data.split(" ");
        String plantId = splitMessage[0];

        String humidity = splitMessage[1];
        String light = splitMessage[2];
        String temperature = splitMessage[3];

        String splitHumidity[] = humidity.split(" ");
        String splitLight[] = light.split(" ");
        String splitTemperature[] = temperature.split(" ");

        int humidityValue = new Integer(splitHumidity[1]);
        int lightValue = new Integer(splitLight[1]);
        int temperatureValue = new Integer(splitTemperature[1]);

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


        return null;
    }
}
