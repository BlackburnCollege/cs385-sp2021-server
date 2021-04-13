package com.servers.application.json_objects;

public class Token {
    private String value;
    private String ip;

    public String getToken(){
        return value;
    }

    public String getIp() {
        return ip;
    }

    public void setToken(String token) { this.value = token; }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
