package com.servers.application;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class Session {

    private AppServerDriver clientConnection;
    private AppServerDriver[] controllers = new AppServerDriver[8];
    private String token = "";
    private HashMap<String, Session> sessIndex = new HashMap<>();
    Random rand = new Random();

    public Session(AppServerDriver client, AppServerDriver[] con, String s){
        this.clientConnection = client;
        this.controllers = con;
        this.token = s;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setClientConnection(AppServerDriver c){
        this.clientConnection = c;
    }

    public AppServerDriver[] getCons(){
        return controllers;
    }

    public String getToken() {
        return token;
    }
    public AppServerDriver getClientConnection(){
        return clientConnection;

    }

    public boolean isInHash(String s){
        Iterator tokenTrav = sessIndex.entrySet().iterator();
        while(tokenTrav.hasNext()){
            Map.Entry mapElement = (Map.Entry)tokenTrav.next();
            if(mapElement.getKey().equals(s)){
                return true;
            }
        }
        return false;
    }
}
