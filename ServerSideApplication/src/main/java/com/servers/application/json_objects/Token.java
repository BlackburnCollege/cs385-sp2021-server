package com.servers.application.json_objects;

public class Token {
    private String token;
    private String ip;

    public String getToken(){
        return token;
    }

    public String getIp() {
        return ip;
    }

    public void setToken(String token) { this.token = token; }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
