package com.servers.application.json_objects;

/**
 * The following is a JSON Object containing data regarding the User's information for connecting to the server and
 * the game client. This Object also stored the information of the controller from the corresponding user.
 */
public class User {
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
