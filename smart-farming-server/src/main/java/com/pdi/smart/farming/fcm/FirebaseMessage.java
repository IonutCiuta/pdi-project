package com.pdi.smart.farming.fcm;

import java.io.Serializable;

/**
 * ionutciuta24@gmail.com on 22.05.2017.
 */
public class FirebaseMessage implements Serializable{

    private FirebaseNotification notification;
    private FirebaseData data;
    private String to;

    public FirebaseMessage(FirebaseNotification notification, FirebaseData data, String to) {
        this.notification = notification;
        this.data = data;
        this.to = to;
    }

    public FirebaseNotification getNotification() {
        return notification;
    }

    public void setNotification(FirebaseNotification notification) {
        this.notification = notification;
    }

    public FirebaseData getData() {
        return this.data;
    }

    public void setData(FirebaseData data) {
        this.data = data;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
