package com.mocha.server.SocketCapsule;

import com.google.gson.Gson;
import com.mocha.server.JsonListenerCapsule.RequestTypes;
import com.mocha.server.JsonListenerCapsule.JsonRequest;

public class SocketCapsule {

    private ServerHandler serverHandler;
    private Gson gson;

    public SocketCapsule(int port, int maxNumberOfClients){

        serverHandler = new ServerHandler(port, maxNumberOfClients);
        System.out.println("Socket Capsule Initialized!");
        gson = new Gson();
    }

    public ClientHandler getClientHandler(int uid){
        return serverHandler.getClientHandler(uid);
    }

    public void sendMessageToAll(String message){
        serverHandler.sendMessageToAll(message);
    }

    public void sendMessage(int uid, String message){
        serverHandler.sendMessage(uid, message);
    }

    public void sendMessageObject(int uid, RequestTypes type, Object o){
        JsonRequest jsonRequest = new JsonRequest(type, o);
        String req = gson.toJson(jsonRequest);

        sendMessage(uid, req);
    }

}
