package com.servers.application;

/**
 * never ended up using this but it would interpret a message and conferm input was practicle and santised
 */
public class WebsocketController implements WebsocketMsgReceiver{

    @Override
    public String interpretMessage(String msg) {
        return msg;
    }
}
