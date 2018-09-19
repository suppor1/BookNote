package com.core.design.decorator;

/**
 * Created by jiangkai
 * Date 2018/9/19
 * 糖装饰者 单价2元
 */
public class SugarDecorator extends Decorator {
    @Override
    public void operate() {
        System.out.println("糖");
        super.operate();
    }
}
