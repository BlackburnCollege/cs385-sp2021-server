package com.servers.application;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.servers.application.json_objects.Joystick;
import com.servers.application.json_objects.JsonHeader;
import com.servers.application.json_objects.UserController;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;

public class WebsocketManger {

    static public LinkedList<String> SendToGameClient;

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        ObjectMapper ob = new ObjectMapper();
        SendToGameClient = new LinkedList<>();



        String test = "{\n" +
                "    \"header\": \"user\",\n" +
                "    \"type\": \"controller\",\n" +
                "    \"jsonBlock\": \"\\\"{ \\\"joystick\\\": { \\\"x\\\":\\\"5\\\", \\\"y\\\":\\\"0\\\" }, \\\"a\\\": \\\"true\\\", \\\"b\\\": \\\"false\\\", \\\"x\\\": \\\"false\\\", \\\"y\\\": \\\"false\\\", \\\"start\\\": \\\"false\\\" }\\\"\"\n" +
                "}";
            JsonNode root = ob.readTree(test);
            JsonHeader yeet2 = ob.readValue(test, JsonHeader.class);
            System.out.println(yeet2.getHeader());
            

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
