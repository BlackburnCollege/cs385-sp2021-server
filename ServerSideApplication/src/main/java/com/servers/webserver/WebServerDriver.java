package com.servers.webserver;


import com.servers.webserver.config.Configuration;
import com.servers.webserver.config.ConfigurationManager;
import com.servers.webserver.core.ServerListenerThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Driver class for the webserver. Serves as a place to initialize the
 * server, connecting the client to the webpage.
 */

public class WebServerDriver {

    // Used to print statements and log various messaged through
    // the execution of the program.
    private final static Logger LOGGER = LoggerFactory.getLogger(WebServerDriver.class);

    public static void main(String[] args) {
        LOGGER.info("Server starting....");

        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/server.json");
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();

        LOGGER.info("Using Port: " + conf.getPort());
        LOGGER.info("Using Webroot: " + conf.getWebroot());


        try {
            ServerListenerThread serverListenerThread = new ServerListenerThread(conf.getPort(), conf.getWebroot());
            serverListenerThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
