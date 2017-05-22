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
    private String status;

    public Notification() {

    }

    public Notification(String plantId, String plantName, String h, String t, String l, Date receivedOn, String status) {
        this.plantId = plantId;
        this.plantName = plantName;
        H = h;
        T = t;
        L = l;
        this.receivedOn = receivedOn;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "plantId='" + plantId + '\'' +
                ", plantName='" + plantName + '\'' +
                ", H='" + H + '\'' +
                ", T='" + T + '\'' +
                ", L='" + L + '\'' +
                ", receivedOn=" + receivedOn +
                ", status='" + status + '\'' +
                '}';
    }

    public static class Builder {
        private Notification notification;

        public Builder() {
            this.notification = new Notification();
        }

        public Builder withPlantId(String plantId) {
            this.notification.setPlantId(plantId);
            return this;
        }

        public Builder withPlantName(String plantName) {
            this.notification.setPlantName(plantName);
            return this;
        }

        public Builder withDate(Date date) {
            this.notification.setReceivedOn(date);
            return this;
        }

        public Builder withSensorValues(String H, String T, String L) {
            this.notification.setL(L);
            this.notification.setT(T);
            this.notification.setH(H);
            return this;
        }

        public Builder withStatus(String status) {
            this.notification.setStatus(status);
            return this;
        }

        public Notification getNotification() {
            return notification;
        }
    }
}
