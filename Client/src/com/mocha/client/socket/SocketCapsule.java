package com.mocha.client.socket;

import com.google.gson.Gson;
import com.mocha.client.Core;
import com.mocha.client.EventCapsule.EventTypes;
import com.mocha.client.JsonListenerCapsule.JsonRequest;
import com.mocha.client.JsonListenerCapsule.RequestTypes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketCapsule {

    PrintWriter out;
    Gson gson = new Gson();

    public SocketCapsule() {

        Socket socket = null;
        try {
            socket = new Socket("localhost", 8081);
            System.out.println("Client Initialized!");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            new Thread(() -> {
                while(true){
                    String a = null;
                    try {
                        a = in.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Core.EventManager.notify(EventTypes.JSON_MESSAGE, a);
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String message){
        out.println(message);
    }

    public void sendMessageObject(RequestTypes type, Object o){
        JsonRequest jsonRequest = new JsonRequest(type, o);
        String req = gson.toJson(jsonRequest);

        sendMessage(req);
    }
}
