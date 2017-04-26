package com.pdi.smart.farming.fcm;

import com.pdi.smart.farming.rest.dto.Notification;
import com.pdi.smart.farming.rest.dto.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ionutciuta24@gmail.com on 27.04.2017.
 */
@Component
public class FcmService {

    @Value("${fcm.server.key}")
    private String fcmServerKey;

    @Value("${fcm.api.url}")
    private String fcmApiUrl;

    public void push(Notification notification, User user) {

    }
}
