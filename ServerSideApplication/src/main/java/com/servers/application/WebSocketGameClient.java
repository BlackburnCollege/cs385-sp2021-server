package com.servers.application;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Currently unsed used to sanatice and recate to messages form the client
 */
public class WebSocketGameClient implements WebsocketMsgReceiver{
    private ObjectMapper OM;

    public WebSocketGameClient(){
        OM = new ObjectMapper();
    }

    @Override
    public String interpretMessage(String msg) {
        //OM.readValue()
        return null;
    }
}
