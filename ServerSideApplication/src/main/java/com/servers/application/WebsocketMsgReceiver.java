package com.servers.application;

/**
 * overall unused but would alow santisation of messages recived from diffrent types of websocket connections
 */
public interface WebsocketMsgReceiver {
    public String interpretMessage(String msg);
}
