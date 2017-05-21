package com.pdi.smart.farming.rest.dto;

import org.springframework.data.annotation.Id;

/**
 * ionutciuta24@gmail.com on 21.05.2017.
 */
public class Plant {
    @Id
    private String id;
    private String userId;
    private String name;

    public Plant(String id, String userId, String name) {
        this.id = id;
        this.userId = userId;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
