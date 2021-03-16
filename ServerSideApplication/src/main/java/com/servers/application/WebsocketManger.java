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

            /*
            Joystick joy = new Joystick();
            joy.setX("5");
            joy.setY("0");

            UserController controlThing = new UserController();
            controlThing.setX("5");
            controlThing.setY("0");
            controlThing.setA("true");
            controlThing.setB("false");
            controlThing.setStart("false");
            controlThing.setJoystick(joy);

        System.out.println(ob.writeValueAsString(controlThing));

            JsonNode root2 = ob.readTree(yeet2.getJsonBlock());
            UserController yeetTwo = ob.readValue(yeet2.getJsonBlock(), UserController.class);
            System.out.println(yeetTwo.getX());

            JsonHeader head2 = new JsonHeader();
            head2.setHeader("this");
            head2.setType("userController");
            head2.setJsonBlock(ob.writeValueAsString(controlThing));
            System.out.println(ob.writeValueAsString(head2));


            JsonNode root3 = ob.readTree(ob.writeValueAsString(head2));
            JsonHeader head3 = ob.readValue(ob.writeValueAsString(head2), JsonHeader.class);
            System.out.println(head3.getType());

            JsonNode root4 = ob.readTree(ob.writeValueAsString(head3.getJsonBlock()));
            UserController controlThingTwo = ob.readValue(head3.getJsonBlock(), UserController.class);
            System.out.println(controlThingTwo.getJoystick().getX());
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
