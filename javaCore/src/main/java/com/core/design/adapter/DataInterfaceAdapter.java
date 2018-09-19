package com.core.design.adapter;

/**
 * Created by jiangkai
 * Date 2018/9/19
 * 适配器实现业务方指定的接口，继承功能实现类，完成适配
 */
public class DataInterfaceAdapter extends Usber implements BuInterface {
    @Override
    public void ps2() {
        this.isUsd();
    }
}
