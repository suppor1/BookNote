package com.core.io;

import java.io.*;

/**
 * Created by jiangkai
 * Date 2018/4/30
 */
public class ReadFiletFromOS {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream(new File(""));
        FileDescriptor fileDescriptor = fileInputStream.getFD();
        fileDescriptor.sync();//强制把数据刷新到物理磁盘中
    }
}
