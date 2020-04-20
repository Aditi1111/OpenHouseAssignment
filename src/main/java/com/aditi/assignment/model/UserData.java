package com.aditi.assignment.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class UserData {

    @Id
    private String userId;

    private String sessionId;

    //do lazy load
    @Cascade(CascadeType.ALL)
    @OneToMany
    private List<Actions> actions;

    public UserData() {

    }

    public UserData(String userId, String sessionId, List<Actions> actions) {
        this.userId = userId;
        this.sessionId = sessionId;
        this.actions = actions;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public List<Actions> getActions() {
        return actions;
    }

    public void setActions(List<Actions> actions) {
        this.actions = actions;
    }
}