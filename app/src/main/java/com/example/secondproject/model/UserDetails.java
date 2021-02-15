package com.example.secondproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

public class UserDetails {
    private String userId;
    private String first_name;
    private String token;

    public UserDetails(){

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
}
