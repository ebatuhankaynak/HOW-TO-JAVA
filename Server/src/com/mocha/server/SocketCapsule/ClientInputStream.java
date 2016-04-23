package com.mocha.server.SocketCapsule;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mocha.server.EventCapsule.EventTypes;

import java.io.*;

public class ClientInputStream extends BufferedReader {

    private Gson gson;
    private int uid;
    public ClientInputStream(InputStream inputStream, int uid) {
        super(new InputStreamReader(inputStream));
        gson = new Gson();
        this.uid = uid;
        setStream();
    }

    private void setStream(){
        new Thread(() -> {
            while(true){
                try {
                    String content = this.readLine();
                  //  Core.EventManager.runMessageEvent(EventTypes.STRING_MESSAGE, content);
                    JsonElement je = new JsonParser().parse(content);
                    JsonObject jo = je.getAsJsonObject();
                    jo.addProperty("uid", uid);
                    Core.EventManager.runMessageEvent(EventTypes.JSON_MESSAGE, gson.toJson(jo));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
