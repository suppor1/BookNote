package com.core.design.proxy.jdk.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by jiangkai
 * Date 2018/4/27
 */
public class AllInterfaceProxy implements InvocationHandler {

    Object tar;//被代理类

    //绑定被代理类,并且生成代理类，返回代理类对象
    public Object bind(Object tar){
        this.tar = tar;
        /**
         * 绑定被代理类实现的所有接口，生成代理类对象
         * loader : 一个ClassLoader 对象，注明生成的代理类由那个ClassLoader加载
         * interfaces : 一个Interface对象的数组，表示的是被代理类需要实现接口（jdk动态代理是基于接口的），如果我提供了一组接口给它，那么这个代理对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法了
         * h: 一个InvocationHandler对象，表示的是当动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上
         */
        Object obj = Proxy.newProxyInstance(tar.getClass().getClassLoader(),tar.getClass().getInterfaces(),this);
        System.out.println("obj:"+obj);
        return obj;
    }

    /**
     *
     * @param proxy 代理对象 既 Proxy.newProxyInstance 生成的实例
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        System.out.println("jdk 动态代理 这里就可以进行所谓的AOP编程了");
        System.out.println("在调用具体函数方法前，执行功能处理");
        result = method.invoke(tar,args);
        System.out.println("在调用具体函数方法后，执行功能处理");
        return result;
    }
}
