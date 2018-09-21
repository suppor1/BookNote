package com.core.design.observer;

/**
 * Created by jiangkai
 * Date 2018/9/21
 * 观察者，主题状态改变时，自己能够同步状态
 */
public interface Observer {
    void update(String message);
}

/**
 * 具体的观察者用户，关注了公众要的用户，就会关注主题
 */
class User implements  Observer{
    private String name;//微信用户名

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name+"收到"+message);
    }
}
