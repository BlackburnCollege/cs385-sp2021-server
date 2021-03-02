package com.servers.application;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;

public class WebsocketConnection extends Thread{

    private AppServerDriver[] threadArray = new AppServerDriver[8];
    private AppServerDriver gameClient;
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

    public void mainTwo() throws IOException, NoSuchAlgorithmException {
        ServerSocket server = new ServerSocket(8000);
        try {
            System.out.println("Server has started on 127.0.0.1:8000.\r\nWaiting for a connection...");

            System.out.println("waiting for the client");
            Socket client = server.accept();
            gameClient = new AppServerDriver(client);
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
