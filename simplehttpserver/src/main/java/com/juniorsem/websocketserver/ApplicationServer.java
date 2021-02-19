package com.juniorsem.websocketserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ApplicationServer {


    ConnectionThread[] threadArray = new ConnectionThread[8];

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        ApplicationServer runner = new ApplicationServer();
        //runner.mainTwo(null);
        ConnectionEndPoint con = new ConnectionEndPoint();
        
    }

    public void mainTwo(String[] args) throws IOException, NoSuchAlgorithmException {
        ServerSocket server = new ServerSocket(8080);
        try {
            System.out.println("Server has started on 127.0.0.1:8080.\r\nWaiting for a connection...");

            for (int i = 0; i < this.threadArray.length; i++) {
                Socket client = server.accept();
                threadArray[i] = new ConnectionThread(client);
                threadArray[i].run();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


