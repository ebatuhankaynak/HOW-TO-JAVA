package com.mocha.client.JsonListenerCapsule;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mocha.client.Core;
import com.mocha.client.EventCapsule.EventTypes;
import com.mocha.client.EventCapsule.MessageEvent;

import java.util.HashMap;
import java.util.Map;

public class JsonListenerCapsule {

    private Map<RequestTypes, JsonListener> listeners = new HashMap<>();
    private Gson gson = new Gson();

    public JsonListenerCapsule(){

        Core.EventManager.addEventListener(EventTypes.JSON_MESSAGE, new MessageEvent() {

            @Override
            public void run(String message) {
                JsonElement je = new JsonParser().parse(message);
                JsonObject jo = je.getAsJsonObject();
                System.out.println(message);
                RequestTypes requestType = RequestTypes.valueOf(jo.getAsJsonPrimitive("type").getAsString());
                listeners.get(requestType).init(gson.toJson(jo.getAsJsonObject("object")));
            }

        });

    }
    public void addJsonListener(RequestTypes type, JsonListener jsonListener){
        listeners.put(type, jsonListener);
    }

}
