package com.mocha.server.SocketCapsule;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ServerHandler {

    private ServerSocket serverSocket;
    private Map<Integer, ClientHandler> clientHandlers = new HashMap<>();

    private int maxNumberOfClients;
    private int currentNumberOfClients = 0;

    private int uid = 0;

    public ServerHandler(int port, int maxNumberOfClients){

        this.maxNumberOfClients = maxNumberOfClients;

        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        connectClients();
    }
    public ClientHandler getClientHandler(int uid){
        return clientHandlers.get(uid);
    }

    public void sendMessage(int uid, String message){
        getClientHandler(uid).sendMessage(message);
    }

    public void sendMessageToAll(String message){
        for (ClientHandler clientHandler : clientHandlers.values()){
            clientHandler.sendMessage(message);
        }
    }

    private void connectClients(){
        new Thread(() -> {
            // TODO what if maxNumberOfClients is equals currentNumberOfClients?
            while(currentNumberOfClients < maxNumberOfClients){

                Socket socket = null;
                try {
                    socket = serverSocket.accept();

                    final Socket finalSocket = socket;

                    new Thread(() -> {
                        currentNumberOfClients++;
                        uid++;
                        ClientHandler clientHandler = new ClientHandler(finalSocket, uid);
                        clientHandlers.put(uid, clientHandler);
                        System.out.println("New client with UID: " + uid);

                    }).start();


                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
    }).start();
    }

}

