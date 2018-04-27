package com.core.design.proxy.jdk.staticProxy;

/**
 * Created by jiangkai on 2018/4/27.
 */
public class UserInterfaceImpl implements UserInterface {
    public void sayHello(String name) {
        System.out.println("Hello" + name);
    }
}
