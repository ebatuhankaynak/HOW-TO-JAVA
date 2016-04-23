package com.mocha.server.JsonListenerCapsule;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;

public abstract class JsonListener<T> {

    private int uid = -1; // client uid which sent the request

    /**
     * @return client uid which sent the request
     */
    protected int getClientUID(){
        return uid;
    }

    public abstract void run(T req);


    public void init(int uid, String message){
        // set current uid
        this.uid = uid;

        Gson gson = new Gson();

        // Call run with a reflection code that gives type T which is the model class
        run(gson.fromJson(message,
                (Class<T>) ((ParameterizedType) getClass()
                        .getGenericSuperclass()).getActualTypeArguments()[0]));
    }

}
