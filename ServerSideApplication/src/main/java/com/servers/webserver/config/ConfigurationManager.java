package com.servers.webserver.config;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.servers.webserver.util.Json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Manages the current configuration settings of the server.
 * Allowing current assessment of the configuration filepath
 * as well as functionality to change the configuration filepath.
 */
public class ConfigurationManager {

    private static ConfigurationManager myConfigurationManager;
    private static Configuration myCurrentConfiguration;

    /**
     * Constructor for the ConfigurationManager Class
     */
    private ConfigurationManager() {
    }

    /**
     * Checks if a Configuration Manager has been created
     * If not, creates a new one.
     * @return The Class's Configuration Manager Object.
     */
    public static ConfigurationManager getInstance(){

        //Checks if a Configuration Manager has been created
        //If not, creates a new one.
        if (myConfigurationManager==null)
            myConfigurationManager = new ConfigurationManager();
            return myConfigurationManager;
        }


    /**
     * Used to load a configuration file by the path provided using
     * a FileReader and StringBuffer to create a Json String which
     * is then converted into a Configuration Object that our servers
     * uses.
     * @param filePath The filepath for the configuration file.
     */
    public void loadConfigurationFile(String filePath) {
        FileReader fileReader = null;


        try {
            fileReader = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            throw new ConfigurationException(e);
        }


        StringBuffer stringBuffer = new StringBuffer();
        int i;


        try {
            while ((i = fileReader.read()) != -1) {
                stringBuffer.append((char) i);
            }
        } catch (IOException e) {
            throw new ConfigurationException(e);
        }


        JsonNode conf = null;


        try {
            conf = Json.parse(stringBuffer.toString());
        } catch (IOException e) {
            throw new ConfigurationException("Error passing the Configuration File", e);
        }


        try {
            myCurrentConfiguration = Json.FromJson(conf, Configuration.class);
        } catch (JsonProcessingException e) {
            throw new ConfigurationException("Error passing the Configuration File, internal", e);
        }
    }

    /**
     * Returns the Current loaded Configuration.
     * Checks to see if there is a current Configuration before
     * completing.
     */
    public Configuration getCurrentConfiguration() {
        if(myCurrentConfiguration == null){
            throw new ConfigurationException("No Current Configuration Set.");
        }
        return myCurrentConfiguration;
    }

}
