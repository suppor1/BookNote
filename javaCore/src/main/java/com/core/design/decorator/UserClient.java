package com.core.design.decorator;

/**
 * Created by jiangkai
 * Date 2018/9/19
 * 用户可以选择
 */
public class UserClient {
    public static void main(String[] args) {
        //首先生产一个最基本的咖啡
        Coffee coffee = new Coffee();
        //用户选择加糖
        SugarDecorator sugarDecorator = new SugarDecorator();
        sugarDecorator.setCoffee(coffee);

        //用户选择加牛奶
        MilkDecorator milkDecorator = new MilkDecorator();
        milkDecorator.setCoffee(sugarDecorator);
        //....

        // 还可以加别的。。。。。。

        //用户最好选好的对象，就是最终的对象
        milkDecorator.operate();//咖啡机生产

    }
}
