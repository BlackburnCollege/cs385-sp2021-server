package com.juniorsem.websocketserver;

import com.juniorsem.httpserver.core.HttpConnectionWorkerThread;
import com.juniorsem.httpserver.core.ServerListenerThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConnectionThread extends Thread {

    private final static Logger LOGGER = LoggerFactory.getLogger(ServerListenerThread.class);

    private Socket clientSocket;

    public ConnectionThread(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {


        try {


            System.out.println("A client connected.");

            InputStream in = clientSocket.getInputStream();
            OutputStream out = clientSocket.getOutputStream();
            Scanner s = new Scanner(in, "UTF-8");
            while (true) {

                while (in.available() == 0) {
                    System.out.println("stuck");
                }

                while (in.available() < 10) {
                    System.out.println("stuck2ElectricBoogaloo");
                }

                String data = s.useDelimiter("\\r\\n\\r\\n").next();
                Matcher get = Pattern.compile("^GET").matcher(data);

                if (get.find()) {
                    Matcher match = Pattern.compile("Sec-WebSocket-Key: (.*)").matcher(data);
                    match.find();
                    byte[] response = ("HTTP/1.1 101 Switching Protocols\r\n"
                            + "Connection: Upgrade\r\n"
                            + "Upgrade: websocket\r\n"
                            + "Sec-WebSocket-Accept: "
                            + Base64.getEncoder().encodeToString(MessageDigest.getInstance("SHA-1").digest((match.group(1) + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes("UTF-8")))
                            + "\r\n\r\n").getBytes("UTF-8");
                    out.write(response, 0, response.length);

                    byte[] decoded = new byte[6];
                    byte[] encoded = new byte[]{(byte) 198, (byte) 131, (byte) 130, (byte) 182, (byte) 194, (byte) 135};
                    byte[] key = new byte[]{(byte) 167, (byte) 225, (byte) 225, (byte) 210};
                    for (int i = 0; i < encoded.length; i++) {
                        decoded[i] = (byte) (encoded[i] ^ key[i & 0x3]);
                    }

                    String message = new String(decoded, StandardCharsets.UTF_8);

                    System.out.println("Checkpoint");

                    System.out.println(message);

                }
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}



