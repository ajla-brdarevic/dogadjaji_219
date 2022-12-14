package com.dogadjaji_219.dogadjaji_219.models.in;

import jakarta.validation.constraints.Null;

public class UserIn {
    @Null
    private Integer id;

    private String email;
    private String password;
    
    public UserIn() {
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    
}
