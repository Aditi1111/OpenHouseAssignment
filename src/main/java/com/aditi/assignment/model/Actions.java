package com.aditi.assignment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Actions {

    @JsonIgnore
    @Id
    @GeneratedValue
    private int actionId;

    //@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZZZZ")
    private String time;//2018-10-18T21:37:28-06:00

    private String type;//could be an enum {"CLICK", "VIEW", "NAVIGATE"}

    @ManyToOne(fetch = FetchType.LAZY)
    private UserData userData;

    //private Properties properties;

    public Actions() {

    }

    public Actions(int actionId, String time, String type) {
        this.actionId = actionId;
        this.time = time;
        this.type = type;
    }

    //@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZZZZ")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

   /* public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }*/
}
