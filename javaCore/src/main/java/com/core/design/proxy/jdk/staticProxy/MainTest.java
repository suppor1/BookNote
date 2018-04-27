package com.core.design.proxy.jdk.staticProxy;

/**
 * Created by jiangkai on 2018/4/27.
 */
public class MainTest {
    public static void main(String[] args) {
        UserProxy userProxy = new UserProxy();
        userProxy.sayHello("BOB");
    }
}
