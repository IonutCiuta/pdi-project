package com.pdi.smart.farming.fcm;

import java.io.Serializable;

/**
 * ionutciuta24@gmail.com on 22.05.2017.
 */
public class FirebaseNotification implements Serializable {
    private String title;
    private String body;

    public FirebaseNotification(String title, String body) {
        super();
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
