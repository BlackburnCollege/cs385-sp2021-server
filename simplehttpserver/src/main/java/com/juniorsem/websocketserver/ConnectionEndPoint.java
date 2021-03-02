package com.juniorsem.websocketserver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/actions")
public class ConnectionEndPoint {




    @OnOpen
    public void onOpen(Session session, EndpointConfig endpointConfig) {
        // Get session and WebSocket connection
        System.out.println("on open");

    }


    @OnMessage
    public void onMessage(Session session, String message) throws IOException {
        // Handle new messages
        System.out.println("the message" + message);
    }

    @OnClose
    public void onClose(Session session) throws IOException {
        // WebSocket connection closes
        System.out.println("on close");
    }


    @OnError
    public void onError(Session session, Throwable throwable) {
        // Do error handling here
        System.out.println("on error");
    }
}
