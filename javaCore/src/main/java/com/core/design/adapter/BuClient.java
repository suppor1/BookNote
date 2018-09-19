package com.core.design.adapter;

/**
 * Created by jiangkai
 * Date 2018/9/19
 * 业务方调用
 */
public class BuClient {
    public static void main(String[] args) {
        BuInterface buInterface = new DataInterfaceAdapter();
        buInterface.ps2();
    }
}
