package com.servers.webserver.core;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Works with the communication and handling of messages.
 */
public class ServerConnectionWorkerThread extends Thread {

    // Socket passed onto the worker thread to interact with.
    private Socket socket;

    // Used to print statements and log various messaged through
    // the execution of the program.
    private final static Logger LOGGER = LoggerFactory.getLogger(ServerConnectionWorkerThread.class);


    /**
     * Constructor for the ServerConnectionWorkerThread class
     * taking in the Socket the class is tasked with interacting
     * with.
     * @param socket
     */
    public ServerConnectionWorkerThread(Socket socket) {
        this.socket = socket;
    }


    /**
     *
     */
    @Override
    public void run() {

        //Declaration outside the try/catch block.

        InputStream inputStream = null;

        OutputStream outputStream = null;

        try {

            // Allows reading into the socket.
            inputStream = socket.getInputStream();
            // Allows writing out of the socket.
            outputStream = socket.getOutputStream();

            String html = new String(Files.readAllBytes(Paths.get("src/main/resources/thisexists/index.html")));


            final String CRLF = "\n\r"; // 13, 10

            String response =
                    "HTTP/1.1 200 OK" + CRLF + //Status Line : HTTP VERSION RESPONSE_CODE RESPONSE_MESSAGE
                            "Content-Length: " + html.getBytes().length + CRLF +// HEADER
                            CRLF + html + CRLF + CRLF;

            outputStream.write(response.getBytes());



        LOGGER.info(" * Connection Processing Finished");
        } catch (IOException e) {
            LOGGER.error("Problem with comunication", e);
            e.printStackTrace();
        } finally {
            // Check if the input stream is still open then close it.
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {}
            }

            // Check if the output stream is still open then close it.
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {}
            }

            // Check if the socket is still open then close it.
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}



