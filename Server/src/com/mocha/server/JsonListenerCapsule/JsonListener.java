package com.mocha.server.JsonListenerCapsule;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;

public abstract class JsonListener<T> {

    private int uid = -1;

    protected int getClientUID(){
        return uid;
    }

    public abstract void run(T req);

    public void init(int uid, String message){
        this.uid = uid;
        Gson gson = new Gson();

        run(gson.fromJson(message,
                (Class<T>) ((ParameterizedType) getClass()
                        .getGenericSuperclass()).getActualTypeArguments()[0]));
    }

}
