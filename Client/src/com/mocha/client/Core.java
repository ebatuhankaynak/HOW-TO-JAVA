package com.mocha.client;

import com.mocha.client.EventCapsule.EventCapsule;
import com.mocha.client.JsonListenerCapsule.JsonListener;
import com.mocha.client.JsonListenerCapsule.JsonListenerCapsule;
import com.mocha.client.socket.SocketCapsule;

public class Core {
    public static EventCapsule EventManager = new EventCapsule();
    public static SocketCapsule SocketManager = new SocketCapsule();
    public static JsonListenerCapsule JsonListenerManager = new JsonListenerCapsule();
}
