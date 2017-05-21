package pdi.smartfarming.dto;

import java.io.Serializable;

/**
 * ionutciuta24@gmail.com on 21.05.2017.
 */

public class FcmToken implements Serializable{
    private String userId;
    private String token;

    public FcmToken() {
    }

    public FcmToken(String userId, String token) {
        this.userId = userId;
        this.token = token;
    }

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

    @Override
    public String toString() {
        return "FcmToken{" +
                "userId='" + userId + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
