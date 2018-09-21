package com.core.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangkai
 * Date 2018/9/21
 * 抽象的被观察者也就是主题，提供注册功能，
 * 观察者注册，
 * 取消注册，
 * 通知观察者
 */
public interface Observerable {
    void registerObserver(Observer observer);//注册观察者
    void removeObserver(Observer observer);//取消注册
    void notifyObserver(String message);//通知观察者
}


/**
 * 具体的主题
 */
class WechatServer implements Observerable{
    //存储关注自己的很多个观察者
    List<Observer> observers = new ArrayList<Observer>();
    @Override
    public void registerObserver(Observer observer) {
        //注册观察者
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        //取消关注
        if(!observers.isEmpty()){
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObserver(String message) {
        //新的消息通知给所有的观察者
        for(Observer observer : observers){
            observer.update(message);
        }
    }

    public void updateMessage(String message){
        notifyObserver(message);
    }
}
