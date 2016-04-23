package com.mocha.server;

import com.mocha.server.EventCapsule.EventCapsule;
import com.mocha.server.SocketCapsule.*;
import com.mocha.server.JsonListenerCapsule.JsonListenerCapsule;
import com.mocha.server.repository.Repository;

public class Core {

    public static SocketCapsule ServerManager = new SocketCapsule(Config.PORT, Config.MAX_NUMBER_OF_CLIENTS);
    public static EventCapsule EventManager = EventCapsule.getInstance();

    public static Repository Repository = new Repository(Config.MONGO_CONNECTION_STRING, Config.MONGO_DB_NAME);
    public static JsonListenerCapsule JsonListenerManager = new JsonListenerCapsule();

}
