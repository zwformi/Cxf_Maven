package com.zw.webservice.impl;

import com.zw.webservice.Hello;

import javax.jws.WebService;

@WebService(endpointInterface = "com.zw.webservice.Hello")
public class HelloImp implements Hello {

    public String say(String name) {
        return "hello,"+name;
    }

}
