package com.servers.application;

import com.fasterxml.jackson.databind.ObjectMapper;

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
