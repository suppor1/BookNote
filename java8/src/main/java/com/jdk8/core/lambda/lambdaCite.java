package com.jdk8.core.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by jiangkai
 * Date 2018/6/1
 */
public class lambdaCite {
    //jdk8 中表达式的应用
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a","b","c","2","3");
        Consumer<String> consumer = str -> System.out.println(str);
        list.forEach(new MyFunction());
    }
}

class MyFunction implements Consumer<String>{
    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}
