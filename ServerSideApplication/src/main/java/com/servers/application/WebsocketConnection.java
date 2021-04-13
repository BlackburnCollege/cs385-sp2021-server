package com.servers.application;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Map;

public class WebsocketConnection extends Thread{

    private AppServerDriver[] threadArray = new AppServerDriver[8];
    private AppServerDriver gameClient;
    private HashMap<String, AppServerDriver> tokenIndex = new HashMap<>();
    Random rand = new Random();

    @Override
    public void run() {
        try {
            mainTwo();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }


    public String tokenGen(){
        String[] chars = {"0","1","2","3","4","5","6","7","8","9",
        "A","B,","C","D","E","F","G","H","I","J","K","L","M","N","O","P",
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

    public void mainTwo() throws IOException, NoSuchAlgorithmException {

        Iterator tokenTrav = tokenIndex.entrySet().iterator();
        ServerSocket server = new ServerSocket(8000);
        try {
            System.out.println("Server has started on 127.0.0.1:8000.\r\nWaiting for a connection...");

            System.out.println("waiting for the client");
            Socket client = server.accept();
            gameClient = new AppServerDriver(client);

            /*while(tokenTrav.hasNext()){
                Map.Entry mapElement = (Map.Entry)tokenTrav.next();
                if(mapElement.getValue() == null){
                    tokenIndex.replace((String)mapElement.getKey(), gameClient);
                }
            }*/
            gameClient.start();

            for (int i = 0; i < this.threadArray.length; i++) {
                client = server.accept();
                threadArray[i] = new AppServerDriver(client);
                threadArray[i].start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    synchronized public AppServerDriver[] getThreadArray() {
        return threadArray;
    }

    synchronized public AppServerDriver getGameClient(){
        return gameClient;
    }
}
