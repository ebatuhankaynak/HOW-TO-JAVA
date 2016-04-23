package com.mocha.server.EventCapsule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventCapsule {

    public Map<EventTypes, List<MessageEvent>> events = new HashMap<>();

    private static EventCapsule instance;

    public static EventCapsule getInstance(){
        if (instance == null)
            instance = new EventCapsule();
        return instance;
    }


    private EventCapsule(){

        for (EventTypes t : EventTypes.values()){
            events.put(t, new ArrayList<>());
        }



        System.out.println("Event Capsule Initialized!");

    }

    public void addMessageEventListener(EventTypes type, MessageEvent messageEvent){
        events.get(type).add(messageEvent);
        // System.out.println("Message Event Added: " + type.toString());
    }


    public void runMessageEvent(EventTypes type, String message){
        // System.out.println("Message Event Runned: " + type.toString());
        for(MessageEvent e : events.get(type)){
            e.run(message);
        }
    }

    public void runMessageEvent(int uid, EventTypes type, String message){
        // System.out.println("Message Event Runned: " + type.toString());
        for(MessageEvent e : events.get(type)){
            e.run(message);
    }
    }
}
