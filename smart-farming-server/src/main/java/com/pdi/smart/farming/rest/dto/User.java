package com.pdi.smart.farming.rest.dto;

import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Set;

/**
 * ionutciuta24@gmail.com on 26.04.2017.
 */
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private Set<String> devicesIds;

    public User() {
        this.devicesIds = new HashSet<>();
    }

    public User(String username) {
        this.username = username;
    }

    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getDevicesIds() {
        return devicesIds;
    }

    public void setDevicesIds(Set<String> devicesIds) {
        this.devicesIds = devicesIds;
    }

    public void addDeviceId(String deviceId) {
        if(devicesIds == null) {
            devicesIds = new HashSet<>();
        }

        devicesIds.add(deviceId);
    }

    public boolean containsDeviceId(String deviceId) {
        return devicesIds != null && devicesIds.contains(deviceId);
    }
}
