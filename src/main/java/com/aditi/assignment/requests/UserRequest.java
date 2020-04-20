package com.aditi.assignment.requests;

import com.aditi.assignment.model.Actions;

import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;
import java.util.List;

public class UserRequest {

    @Pattern(regexp = "[A-Za-z0-9]{1,20}")
    private String userId;

    @Pattern(regexp = "[A-Za-z0-9]{1,20}")
    private String sessionId;

    //do lazy load
    //@OneToMany
    private List<Actions> actions;

    public UserRequest() {

    }

    public UserRequest(String userId, String sessionId, List<Actions> actions) {
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
