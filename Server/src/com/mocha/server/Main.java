package com.mocha.server;

import com.mocha.server.CompilerCapsule.CompilerCapsule;
import com.mocha.server.EventCapsule.EventTypes;
import com.mocha.server.JsonListenerCapsule.RequestTypes;
import com.mocha.server.listeners.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Mocha Initialized!");
        Core.EventManager.addMessageEventListener(EventTypes.STRING_MESSAGE, message -> System.out.println("Message Received: " + message));

        Core.JsonListenerManager.addJsonListener(RequestTypes.LOGIN, new LoginListener());
        Core.JsonListenerManager.addJsonListener(RequestTypes.REGISTER, new RegisterListener());
        Core.JsonListenerManager.addJsonListener(RequestTypes.QUESTION, new QuestionListener());
        Core.JsonListenerManager.addJsonListener(RequestTypes.COMPILE, new CompileListener());
        Core.JsonListenerManager.addJsonListener(RequestTypes.UPDATE, new UpdateListener());

        Scanner in = new Scanner(System.in);
        String str;
        while((str = in.nextLine()) != null){
            Core.ServerManager.sendMessageToAll(str);
        }
    }
}
