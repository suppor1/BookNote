package com.core.Test;

/**
 * Created by jiangkai
 * Date 2018/9/13
 */
public class HelloMyLoader {
    public HelloMyLoader() {
        System.out.println("嗯，是的，我是由"+getClass().getClassLoader().getClass()+"加载进来的");
        
    }
}
