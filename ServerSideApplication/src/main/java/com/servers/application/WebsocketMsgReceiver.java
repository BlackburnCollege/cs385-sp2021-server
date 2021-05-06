package com.servers.application;

/**
 * Overall unused but would allow santisation of messages received from different types of websocket connections
 */
public interface WebsocketMsgReceiver {
    public String interpretMessage(String msg);
}
