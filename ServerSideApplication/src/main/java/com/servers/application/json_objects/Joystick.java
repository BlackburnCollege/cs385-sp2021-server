package com.servers.application.json_objects;

/**
 * This is a JSON Object that contains the data regarding the joystick or the player's movement on the x and y scale.
 */
public class Joystick {
    private String x;
    private String y;


    // Getter Methods

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }

    // Setter Methods

    public void setX(String x) {
        this.x = x;
    }

    public void setY(String y) {
        this.y = y;
    }
}
