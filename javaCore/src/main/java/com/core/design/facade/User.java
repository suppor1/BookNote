package com.core.design.facade;

/**
 * Created by jiangkai
 * Date 2018/9/20
 */
public class User {
    public static void main(String[] args) {
        ComputerFacade computerFacade = new ComputerFacade();
        computerFacade.start();
        System.out.println("====================");
        computerFacade.shutdown();
    }
}
