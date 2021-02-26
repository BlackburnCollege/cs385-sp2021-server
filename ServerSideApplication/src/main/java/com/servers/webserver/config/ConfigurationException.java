package com.servers.webserver.config;


/**
 * A subclass of RuntimeException to personalize and group specifically
 * errors in the Configuration classes.
 */
public class ConfigurationException extends RuntimeException {
    public ConfigurationException() {
    }

    public ConfigurationException(String message) {
        super(message);
    }

    public ConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigurationException(Throwable cause) {
        super(cause);
    }

}
