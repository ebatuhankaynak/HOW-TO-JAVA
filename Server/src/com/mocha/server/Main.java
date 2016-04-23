package com.mocha.server;

import com.mocha.server.EventCapsule.EventTypes;
import com.mocha.server.JsonListenerCapsule.RequestTypes;
import com.mocha.server.listeners.LoginListener;
import com.mocha.server.listeners.QuestionListener;
import com.mocha.server.listeners.RegisterListener;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        System.out.println("Mocha Initialized!");
        Core.EventManager.addMessageEventListener(EventTypes.STRING_MESSAGE, message -> System.out.println("Message Received: " + message));



        com.mocha.server.CompilerCapsule.CompilerCapsule compilerCapsule = new com.mocha.server.CompilerCapsule.CompilerCapsule();
        /*
        compilerCapsule.compile("public class Main\n" +
                "{  \n" +
                "        public static void main(String args[])\n" +
                "        {\n" +
                "           System.out.println(\"Hello World!\\nasddsa\");\n" +
                "        }\n" +
                "}\n");*/

        Core.JsonListenerManager.addJsonListener(RequestTypes.LOGIN, new LoginListener());
        Core.JsonListenerManager.addJsonListener(RequestTypes.REGISTER, new RegisterListener());
        Core.JsonListenerManager.addJsonListener(RequestTypes.QUESTION, new QuestionListener());

        Scanner in = new Scanner(System.in);
        String str;
        while((str = in.nextLine()) != null){
            Core.ServerManager.sendMessageToAll(str);

        }

    }

}
