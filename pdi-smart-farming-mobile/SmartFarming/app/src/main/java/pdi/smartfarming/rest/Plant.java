package pdi.smartfarming.rest;

import java.util.Date;

/**
 * ionutciuta24@gmail.com on 20.05.2017.
 */

public class Plant {
    private String id;
    private String name;
    private String status;
    private Date lastUpdate;

    public Plant(String name, String status, Date lastUpdate) {
        this.name = name;
        this.status = status;
        this.lastUpdate = lastUpdate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
