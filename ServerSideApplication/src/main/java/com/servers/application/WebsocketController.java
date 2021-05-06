package com.servers.application;

/**
 * Never ended up using this but it would interpret a message and confirm input was practical and santised
 */
public class WebsocketController implements WebsocketMsgReceiver{

    @Override
    public String interpretMessage(String msg) {
        return msg;
    }
}
