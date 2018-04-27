package com.core.design.proxy.jdk.dynamicProxy;

/**
 * Created by jiangkai on 2018/4/27.
 */
public class UserInterfaceImpl implements UserInterface,ProvinceInterface {
    public void sayHello(String name) {
        System.out.println("Hello" + name);
    }

    public String printProvince(String provinceName){
        return provinceName;
    }
}
