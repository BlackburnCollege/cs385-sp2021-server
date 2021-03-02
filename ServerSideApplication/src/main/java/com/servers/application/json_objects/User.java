package com.servers.application.json_objects;

/**
 *
 */
public class User {
    private String header;
    private String name;
    private String ip;
    private UserController controller;


    // Getter Methods

    public String getName() {
        return name;
    }

    public String getIp() {
        return ip;
    }

    public UserController getController() {
        return controller;
    }

    // Setter Methods

    public void setName(String name) {
        this.name = name;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setController(UserController controller) {
        this.controller = controller;
    }
}
