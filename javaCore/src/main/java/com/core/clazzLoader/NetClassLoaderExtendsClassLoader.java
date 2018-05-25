package com.core.clazzLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by jiangkai
 * Date 2018/5/12
 */
public class NetClassLoaderExtendsClassLoader extends ClassLoader {
    private String classPath;
    private String packageName = "com.jiangkai.classoader";

    public NetClassLoaderExtendsClassLoader(ClassLoader parent, String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> parenLoad = findLoadedClass(name);//判断该类是否已经被加载
        if (null != parenLoad){
            return parenLoad;
        }
        if(packageName.startsWith(name)){
            byte[] loadData = getData(name);
            loadData = decode(loadData);
            if(loadData != null){
                Class<?> classObject = defineClass(name,loadData,0,loadData.length);
                return classObject;
            }else{
                new ClassNotFoundException(name);
            }
        }else {
            return super.loadClass(name);
        }
        return null;
    }

    private byte[] getData(String name){
        String path = classPath+ File.separatorChar+name.replaceAll(".",String.valueOf(File.separatorChar))+".class";
        try {
            URL url = new URL(path);
            InputStream inputStream = url.openStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int num = 0;
            while ((num = inputStream.read(buffer)) != -1){
                byteArrayOutputStream.write(buffer,0,buffer.length);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private byte[] decode(byte[] src){
        // 处理网络编码问题
        return src;
    }
}
