package com.mocha.Admin.JsonListenerCapsule;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;

public abstract class JsonListener<T> {

    /**
     * @return client uid which sent the request
     */
    public abstract void run(T req);


    public void init(String message){
        // set current uid

        Gson gson = new Gson();

        // Call run with a reflection code that gives type T which is the model class
        run(gson.fromJson(message,
                (Class<T>) ((ParameterizedType) getClass()
                        .getGenericSuperclass()).getActualTypeArguments()[0]));
    }

}
