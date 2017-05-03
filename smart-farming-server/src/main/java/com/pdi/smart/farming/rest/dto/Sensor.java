package com.pdi.smart.farming.rest.dto;

/**
 * ionutciuta24@gmail.com on 26.04.2017.
 */
public class Sensor {
    private String id;
    private Type type;

    public Sensor() {
    }

    public Sensor(String id, Type type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Type {
        LIGHT, HUMIDITY, TEMPERATURE
    }
}
