package com.aditi.assignment.response;

import com.aditi.assignment.model.UserData;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public class UserDataResponse {

    private Status status;
    private List<String> validationMessages;
    private List<UserData> userData;

    @JsonIgnore
    private HttpStatus httpStatus;

    public enum Status{OK, ERROR;}

    public UserDataResponse(BindingResult validatResults ) {
        this.status = Status.ERROR;
        List<String> validationMessages = new ArrayList<>();
        for(FieldError fe: validatResults.getFieldErrors()){
            validationMessages.add(fe.getDefaultMessage());
        }
        this.validationMessages = validationMessages;
    }

    public UserDataResponse(Status status) {
        this.status = status;
    }

    public UserDataResponse(Status status, List<UserData> userData) {
        this.status = status;
        this.userData = userData;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public List<UserData> getUserData() {
        return userData;
    }

    public void setUserData(List<UserData> userData) {
        this.userData = userData;
    }

    public List<String> getValidationMessages() {
        return validationMessages;
    }

    public void setValidationMessages(List<String> validationMessages) {
        this.validationMessages = validationMessages;
    }
}
