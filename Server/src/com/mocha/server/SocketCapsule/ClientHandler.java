package com.mocha.server.SocketCapsule;

import com.mocha.server.EventCapsule.EventTypes;

import java.io.IOException;
import java.net.Socket;

public class ClientHandler {

    private Socket socket;
    private ClientInputStream in;
    private ClientOutputStream out;
    private int uid;
    public ClientHandler(Socket socket, int uid){
        this.socket = socket;
        this.uid = uid;
        initializeInput();
        initializeOutput();
    }

    public void sendMessage(String message){
        out.println(message);
    }

    public ClientOutputStream getOutputStream(){
        return out;
    }

    private void initializeInput (){
        try {
            in = new ClientInputStream(socket.getInputStream(), uid);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeOutput(){
        try {
            out = new ClientOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeSocket(){
        try {
            socket.close();
            Core.EventManager.runMessageEvent(EventTypes.CLOSE_SOCKET, String.valueOf(uid));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
