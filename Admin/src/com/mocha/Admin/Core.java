package com.mocha.Admin;

import com.mocha.Admin.EventCapsule.EventCapsule;
import com.mocha.Admin.JsonListenerCapsule.JsonListenerCapsule;
import com.mocha.Admin.socket.SocketCapsule;

public class Core {
    public static EventCapsule EventManager = new EventCapsule();
    public static SocketCapsule SocketManager = new SocketCapsule();
    public static JsonListenerCapsule JsonListenerManager = new JsonListenerCapsule();
    public static Storage Storage = new Storage();
}
