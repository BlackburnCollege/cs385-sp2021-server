package com.servers.application.json_objects;

/**
 * The following is a JSON Object used to send data regarding the users controller to the client.
 */
public class UserController {


    Joystick JoystickObject;
    private String a;
    private String b;
    private String x;
    private String y;
    private String start;


    // Getter Methods

    public Joystick getJoystick() {
        return JoystickObject;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }

    public String getStart() {
        return start;
    }

    // Setter Methods

    public void setJoystick(Joystick joystickObject) {
        this.JoystickObject = joystickObject;
    }

    public void setA(String a) {
        this.a = a;
    }

    public void setB(String b) {
        this.b = b;
    }

    public void setX(String x) {
        this.x = x;
    }

    public void setY(String y) {
        this.y = y;
    }

    public void setStart(String start) {
        this.start = start;
    }

}
