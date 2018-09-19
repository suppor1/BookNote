package com.core.design.decorator;

/**
 * Created by jiangkai
 * Date 2018/9/19
 * 装饰者抽象类，考虑到装饰者和被装饰者有共同的一些行为，我们构建一个抽象类，实现共同的操作，具体的装饰者或者被装饰者继承该类，实现自己的操作
 */
public abstract class Decorator implements Component{
    private Decorator coffee;//基本类 就 是被装饰的对象

    public void setCoffee(Decorator coffee) {
        this.coffee = coffee;
    }

    public Decorator getCoffee() {
        return coffee;
    }

    @Override
    public void operate() {
        if(null != coffee){
            coffee.operate();//这是最基本的操作
        }
    }
}
