package com.servers.application;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.servers.application.json_objects.Joystick;
import com.servers.application.json_objects.JsonHeader;
import com.servers.application.json_objects.UserController;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

/**
 * Handles the websockets connections and active sessions. Responsible for creating and distributing sessions
 */
public class WebsocketManger {

    static public LinkedList<String> SendToGameClient;
    static private HashMap<String, Session> sessions = new HashMap<>();

    static private Random rand = new Random();


    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        ObjectMapper ob = new ObjectMapper();
        SendToGameClient = new LinkedList<>();
            

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

    /**
     * generates a sudo random token for sessions
     * @return
     */
     public static String tokenGen(){
        String[] chars = {"0","1","2","3","4","5","6","7","8","9",
                "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P",
                "Q","R","S","T","U","V","W","X","Y","Z"};
        String token = "";
        int max = 36;
        int randNum =0;
        for(int i =0; i<4; i++){
            randNum = rand.nextInt(max);
            token = token + chars[randNum];
        }

        return token;
    }

    /**
     * checks the hashmap for a session via its token
     * @param key
     * @return
     */
    public static Session getSession(String key){
        return sessions.get(key);
    }

    /**
     * creates a session withe a client connection
     * @param client
     * @return the created session
     */
    public static Session createSession(AppServerDriver client){
        String token = tokenGen();
        Session session = new Session(client,new LinkedList(), token);
        System.out.println("Token created " + token);
        sessions.put(token,session);
        return session;
    }
}
