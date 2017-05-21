package pdi.smartfarming.dto;

import java.util.Date;

/**
 * ionutciuta24@gmail.com on 20.05.2017.
 */

public class Notification {
    private String plantId;
    private String plantName;
    private String H;
    private String T;
    private String L;
    private Date receivedOn;

    public Notification(String plantId, String plantName, String h, String t, String l, Date receivedOn) {
        this.plantId = plantId;
        this.plantName = plantName;
        H = h;
        T = t;
        L = l;
        this.receivedOn = receivedOn;
    }

    public String getPlantId() {
        return plantId;
    }

    public void setPlantId(String plantId) {
        this.plantId = plantId;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
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

    public Date getReceivedOn() {
        return receivedOn;
    }

    public void setReceivedOn(Date receivedOn) {
        this.receivedOn = receivedOn;
    }
}
