package com.servers.application;

import java.util.*;

/**
 * The session represents a single client and the connected controllers
 */
public class Session {

    private AppServerDriver clientConnection;
    private String token = "";
    Random rand = new Random();
    private LinkedList conList = new LinkedList();

    /**
     * Sets up a session with some defults Must have a client!
     * @param client
     * @param l
     * @param s
     */
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
