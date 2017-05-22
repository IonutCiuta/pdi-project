package com.pdi.smart.farming.fcm;

import com.pdi.smart.farming.rest.dto.Notification;

import java.util.Date;

/**
 * ionutciuta24@gmail.com on 22.05.2017.
 */
public class FirebaseData {
    private String plantId;
    private String plantName;
    private String H;
    private String T;
    private String L;
    private Date date;
    private String status;

    public FirebaseData(String plantId, String plantName, String h, String t, String l, Date date, String status) {
        this.plantId = plantId;
        this.plantName = plantName;
        H = h;
        T = t;
        L = l;
        this.date = date;
        this.status = status;
    }

    public String getPlantId() {
        return plantId;
    }

    public void setPlantId(String plantId) {
        this.plantId = plantId;
    }

    public String getH() {
        return H;
    }

    public void setH(String h) {
        H = h;
    }

    public String getT() {
        return T;
    }

    public void setT(String t) {
        T = t;
    }

    public String getL() {
        return L;
    }

    public void setL(String l) {
        L = l;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    @Override
    public String toString() {
        return "Data{" +
                "plantId='" + plantId + '\'' +
                ", H='" + H + '\'' +
                ", T='" + T + '\'' +
                ", L='" + L + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }


}
