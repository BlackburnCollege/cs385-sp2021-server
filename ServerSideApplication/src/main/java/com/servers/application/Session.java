package com.servers.application;

import java.util.*;


public class Session {

    private AppServerDriver clientConnection;
    private String token = "";
    Random rand = new Random();
    private LinkedList conList = new LinkedList();


    public Session(AppServerDriver client, LinkedList l, String s){
        this.clientConnection = client;
        this.conList = l;
        this.token = s;

    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setConList (LinkedList list){ this.conList = list; }

    public void setClientConnection(AppServerDriver c){
        System.out.println("set client connection");
        this.clientConnection = c;
    }

    public LinkedList getCons(){
        return conList;
    }

    public String getToken() {
        return token;
    }

    public AppServerDriver getClientConnection(){ return clientConnection; }


}
