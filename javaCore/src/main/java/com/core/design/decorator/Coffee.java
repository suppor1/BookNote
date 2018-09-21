package com.core.design.decorator;

/**
 * Created by jiangkai
 * Date 2018/9/19
 * 被装饰的类
 *
 */
public class Coffee extends Decorator{
    @Override
    public void operate() {
        System.out.println("coffee");
    }
}
