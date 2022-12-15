package com.helpers;

public class JwtResponse {
    private String accessToken;

    public JwtResponse(String accesToken){
        this.accessToken = accesToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

}
