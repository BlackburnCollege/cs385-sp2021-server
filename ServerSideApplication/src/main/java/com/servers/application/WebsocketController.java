package com.servers.application;

public class WebsocketController implements WebsocketMsgReceiver{
    @Override
    public String interpretMessage(String msg) {
        return msg;
    }
}
