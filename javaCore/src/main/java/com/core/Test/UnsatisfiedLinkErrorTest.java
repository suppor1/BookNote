package com.core.Test;

/**
 * Created by jiangkai
 * Date 2018/5/11
 */
public class UnsatisfiedLinkErrorTest {
    public native void nativeMethod();
    static {
        System.loadLibrary("NoLib");
    }

    public static void main(String[] args) {
        new UnsatisfiedLinkErrorTest();
    }
}
