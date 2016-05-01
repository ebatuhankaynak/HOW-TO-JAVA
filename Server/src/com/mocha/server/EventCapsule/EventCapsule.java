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
    }

    public void addMessageEventListener(EventTypes type, MessageEvent messageEvent){
        events.get(type).add(messageEvent);
    }


    public void runMessageEvent(EventTypes type, String message){
        for(MessageEvent e : events.get(type)){
            e.run(message);
        }
    }

    public void runMessageEvent(int uid, EventTypes type, String message){
        for(MessageEvent e : events.get(type)){
            e.run(message);
        }
    }
}
