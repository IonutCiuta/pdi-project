package com.pdi.smart.farming.rest.dto;

import java.util.Date;

/**
 * ionutciuta24@gmail.com on 26.04.2017.
 */
public class Notification {
    private String title;
    private String body;
    private String to;
    private Data data;

    public Notification(String title, String body, String to, Data data) {
        this.title = title;
        this.body = body;
        this.to = to;
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", to='" + to + '\'' +
                ", data=" + data +
                '}';
    }

    public static class Data {
        String plantId;
        String H;
        String T;
        String L;
        Date date;
        String status;

        public Data(String plantId, String h, String t, String l, Date date, String status) {
            this.plantId = plantId;
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
}