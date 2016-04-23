package com.mocha.client.EventCapsule;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventCapsule
{
    // TODO: 28.3.2016 çok uğraşıyo valla yazık tüm eventHandlerlar bakıyo

    private Map<EventTypes, List<MessageEvent>> eventsMap;
    private Gson gson = new Gson();

    public EventCapsule()
    {
        eventsMap = new HashMap<EventTypes, List<MessageEvent>>();
        for (EventTypes eventType : EventTypes.values())
        {
            eventsMap.put(eventType, new ArrayList<MessageEvent>());
        }
    }
    public void addEventListener(EventTypes eventType, MessageEvent messageEvent)
    {
        eventsMap.get(eventType).add(messageEvent);
    }

    public void notify(EventTypes eventType, String message)
    {
        for(MessageEvent messageEvent : eventsMap.get(eventType))
        {
            messageEvent.run(message);
        }
    }

    public void notifyByObject(EventTypes eventType, Object o){
        notify(eventType, gson.toJson(o));
    }
}
