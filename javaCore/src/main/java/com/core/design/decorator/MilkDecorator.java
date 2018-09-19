package com.core.design.decorator;

/**
 * Created by jiangkai
 * Date 2018/9/19
 * 牛奶单价 5 元
 */
public class MilkDecorator extends Decorator {
    @Override
    public void operate() {
        System.out.println("牛奶");
        super.operate();
    }
}
