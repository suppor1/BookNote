package com.core.design.proxy.jdk.staticProxy;

/**
 * Created by jiangkai on 2018/4/27.
 */
public class UserProxy implements UserInterface{

    UserInterface userInterface = new UserInterfaceImpl();
    public void sayHello(String name) {
        System.out.println("代理类 AOP");
        userInterface.sayHello(name);
        System.out.println("代理类+end");
    }
}
