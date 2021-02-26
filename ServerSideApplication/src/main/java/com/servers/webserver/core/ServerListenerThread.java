package com.servers.webserver.core;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * A subclass of Thread, using Threads from our server to execute
 * some sort of process with the client connecting to the port the
 * Server is listening to. Accepts the connection from a particular socket.
 * This class will continue accepting connection and creating
 * ServerConnectionWorkerThreads to handle the processes and messaging
 * of each connection.
 */
public class ServerListenerThread extends Thread{

    //The Port and Webroot the thread is listening to.
    private int port;
    private String webroot;

    //Creates a ServerSocket listening to the port acquired from
    //the server's Configuration, and listens for anyone trying to
    //connect.
    private ServerSocket serverSocket;

    // Used to print statements and log various messaged through
    // the execution of the program.
    private final static Logger LOGGER = LoggerFactory.getLogger(ServerListenerThread.class);

    /**
     * Constructor for our ServerListenerThread
     * @param port The port the Server is listening to.
     * @param webroot The webroot being addressed.
     */
    public ServerListenerThread(int port, String webroot)throws IOException {
        this.port = port;
        this.webroot = webroot;
        this.serverSocket= new ServerSocket(this.port);
    }

    /**
     *
     */
    @Override
    public void run() {

            try {

                // Runs while the server socket is in good condition and not closed.
                while (serverSocket.isBound() && !serverSocket.isClosed()) {

                    // ServerSocket.accept returns the socket that accepted.
                    Socket socket = this.serverSocket.accept();

                    LOGGER.info(" * Connection accepted: " + socket.getInetAddress());

                    // Create a worker thread dedicated to working with the recently
                    // accepted socket.
                    ServerConnectionWorkerThread workerThread = new ServerConnectionWorkerThread(socket);
                    workerThread.start();


                }

            } catch (IOException e) {
                e.printStackTrace();
                LOGGER.error("Problem with setting socket", e);
            } finally {
                // Check if the socket is still open then close it.
                if (serverSocket != null) {
                    try {
                        serverSocket.close();
                    } catch (IOException e) {}
                }
            }

        }
    }
