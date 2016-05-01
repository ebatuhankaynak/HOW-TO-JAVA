package com.mocha.server.SocketCapsule;

import com.mocha.server.EventCapsule.EventTypes;
import com.mocha.server.EventCapsule.MessageEvent;

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

        Core.EventManager.addMessageEventListener(EventTypes.CLOSE_SOCKET, new MessageEvent() {
            @Override
            public void run(String message) {
                clientHandlers.remove(Integer.parseInt(message));
                currentNumberOfClients--;
            }
        });

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
                    }).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

