package com.mocha.server;

import com.mocha.server.EventCapsule.EventTypes;
import com.mocha.server.JsonListenerCapsule.RequestTypes;
import com.mocha.server.listeners.CompileListener;
import com.mocha.server.listeners.LoginListener;
import com.mocha.server.listeners.QuestionListener;
import com.mocha.server.listeners.RegisterListener;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        System.out.println("Mocha Initialized!");
        Core.EventManager.addMessageEventListener(EventTypes.STRING_MESSAGE, message -> System.out.println("Message Received: " + message));



        String code = "public static int factorial(int n){if (n == 0){return 1;} else {return n * factorial(n - 1);}}";
        com.mocha.server.CompilerCapsule.CompilerCapsule compilerCapsule = new com.mocha.server.CompilerCapsule.CompilerCapsule();
        String wraped = " public class Main{"+ code+" public static void main(String[] args){System.out.println(factorial(Integer.parseInt(args[0])));}}";
        //String  [] output = compilerCapsule.compile(wraped,);

        Core.JsonListenerManager.addJsonListener(RequestTypes.LOGIN, new LoginListener());
        Core.JsonListenerManager.addJsonListener(RequestTypes.REGISTER, new RegisterListener());
        Core.JsonListenerManager.addJsonListener(RequestTypes.QUESTION, new QuestionListener());
        Core.JsonListenerManager.addJsonListener(RequestTypes.COMPILE, new CompileListener());

       // for (int i = 0; i < output.length;i++)
        //{
         //   System.out.println(output[i]);
        //}
        Scanner in = new Scanner(System.in);
        String str;
        while((str = in.nextLine()) != null){
            Core.ServerManager.sendMessageToAll(str);

        }

    }

}
