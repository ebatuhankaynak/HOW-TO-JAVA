package com.mocha.Admin.JsonListenerCapsule;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;

public abstract class JsonListener<T> {

    public abstract void run(T req);

    public void init(String message){
        Gson gson = new Gson();

        run(gson.fromJson(message,
                (Class<T>) ((ParameterizedType) getClass()
                        .getGenericSuperclass()).getActualTypeArguments()[0]));
    }

}
