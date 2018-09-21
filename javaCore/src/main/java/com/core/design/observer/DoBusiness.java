package com.core.design.observer;

/**
 * Created by jiangkai
 * Date 2018/9/21
 * 这个类相当于微信公众号（主题）的运营人员，掌管全局
 */
public class DoBusiness {
    public static void main(String[] args) {
        WechatServer wechatServer = new WechatServer();

        Observer userZhang = new User("ZhangSan");
        Observer userLi = new User("LiSi");
        Observer userWang = new User("WangWu");

        wechatServer.registerObserver(userZhang);//关乎
        wechatServer.registerObserver(userLi);
        wechatServer.registerObserver(userWang);
        wechatServer.updateMessage("PHP是世界上最好用的语言！");

        System.out.println("----------------------------------------------");
        wechatServer.removeObserver(userZhang);
        wechatServer.updateMessage("JAVA是世界上最好用的语言！");
    }
}
