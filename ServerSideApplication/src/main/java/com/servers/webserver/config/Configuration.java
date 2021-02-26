package com.servers.webserver.config;


/**
 * Stores Configuration properties regarding the server.
 * What port the server is listening through as well as the
 * webroot where requested files are stored.
 */
public class Configuration {

    //Port being listened through.
    private int port;
    //Location where requested files are stored.
    private String webroot;


    /**
     * Getter for the Port
     * @return Current Port configured
     */
    public int getPort() {
        return port;
    }

    /**
     * Setter for the Port
     * @param port Desired port to be listening to
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * Getter for the Webroot
     * @return Current Webroot location
     */
    public String getWebroot() {
        return webroot;
    }

    /**
     * Setter for the Webroot
     * @param webroot Desired location of the webroot
     */
    public void setWebroot(String webroot) {
        this.webroot = webroot;
    }
}
