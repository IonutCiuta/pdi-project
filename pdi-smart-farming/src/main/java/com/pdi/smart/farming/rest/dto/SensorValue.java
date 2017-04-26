package com.pdi.smart.farming.rest.dto;

/**
 * ionutciuta24@gmail.com on 26.04.2017.
 */
public class SensorValue {
    private Double value;
    private Sensor sensor;

    public SensorValue() {
    }

    public SensorValue(Double value, Sensor sensor) {
        this.value = value;
        this.sensor = sensor;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
