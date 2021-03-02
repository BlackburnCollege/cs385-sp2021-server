package com.servers.application;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.servers.application.json_objects.MessageHeader;
import com.servers.application.json_objects.UserController;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WebsocketManger {

    static public LinkedList<String> SendToGameClient;

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        ObjectMapper ob = new ObjectMapper();
        SendToGameClient = new LinkedList<>();
        /*
        String test = "{\"header\": \"controller\", \"joystick\": { \"x\":\"5\", \"y\":\"0\" }, \"a\": \"true\", \"b\": \"false\", \"x\": \"false\", \"y\": \"false\", \"start\": \"false\" }";
        JsonNode root = ob.readTree(test);
        System.out.println(root.at("/header").toString());
        if(root.at("/header").toString().equals("\"controller\"")){
            UserController yeet2 = ob.readValue(test, UserController.class);
            System.out.println(yeet2.getJoystick().getX());
        }

         */
        WebsocketConnection runner = new WebsocketConnection();
        runner.start();
        while (true){
            if(runner.getGameClient() != null){
                while(SendToGameClient.peek() != null){
                    System.out.println("2");
                    runner.getGameClient().sendMessage(SendToGameClient.pop());
                }
            }

            for (int i = 0; i < runner.getThreadArray().length; i++) {

            }
        }

    }
}
