package com.core.design.proxy.jdk.dynamicProxy;

/**
 * Created by jiangkai on 2018/4/27.
 */
public class MainTest {
    public static void main(String[] args) {

        //设置这个值，可以把生成的代理类，输出出来。 /* 设置此系统属性,让JVM生成的Proxy类写入文件.保存路径为：com/sun/proxy(如果不存在请手工创建) */
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        //获得 代理类对象
        AllInterfaceProxy proxyClassInstance = new AllInterfaceProxy();

        //获得被代理类对象
        UserInterfaceImpl user = new UserInterfaceImpl();
        System.out.println("被代理类实例："+user);
        //绑定被被代理类实现的所有接口,获得代理对象
        Object proxyInstance = proxyClassInstance.bind(user); // 代理对象

        UserInterface userInterface = (UserInterface)proxyInstance;//userInterface 作为 UserInterface 的代理

        ProvinceInterface provinceInterface = (ProvinceInterface)proxyInstance;//provinceInterface 作为 ProvinceInterface 的代理
        //方法调用，体现aop编程
        userInterface.sayHello("BOB");

        String proName = provinceInterface.printProvince("gansu");
        System.out.println("BOB from: "+proName);
    }
}


