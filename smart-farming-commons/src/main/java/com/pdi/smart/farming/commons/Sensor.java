package com.pdi.smart.farming.commons;

/**
 * ionutciuta24@gmail.com on 26.04.2017.
 */
public class Sensor {
    private Type type;
    private int value;

    public Sensor() {
    }

    public Sensor(Type type, int value) {
        this.type = type;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
