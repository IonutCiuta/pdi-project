package com.pdi.smart.farming.rest.dto;

/**
 * ionutciuta24@gmail.com on 21.05.2017.
 */
public class FcmToken {
    private String userId;
    private String token;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
