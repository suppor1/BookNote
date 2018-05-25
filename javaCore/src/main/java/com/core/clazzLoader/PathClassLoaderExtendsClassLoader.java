package com.core.clazzLoader;

import java.io.*;

/**
 * Created by jiangkai
 * Date 2018/5/12
 */
public class PathClassLoaderExtendsClassLoader extends ClassLoader {
    String classPath;

    String packageName;

    public PathClassLoaderExtendsClassLoader (String classPath) {
        this.classPath = classPath;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if(name.startsWith(packageName)){
            byte[] classBytes = getData(name);
            if(classBytes == null){
                new ClassNotFoundException(name);
            }else {
                Class<?> classObject = defineClass(name,classBytes,0,classBytes.length);
                return classObject;
            }
        }else {
            super.loadClass(name);
        }
        return super.loadClass(name);
    }

    public byte[] getData(String className){
        String path = classPath+ File.separatorChar
                +className.replaceAll("\\.",String.valueOf(File.separatorChar))
                +".class";
        try {
            InputStream inputStream = new FileInputStream(path);
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

    public static void main(String[] args) {
        try {
            PathClassLoaderExtendsClassLoader pathClassLoaderExtendsClassLoader
                    = new PathClassLoaderExtendsClassLoader("/Users/jiangkai/myproject/booknote/javaCore/target/classes");
            pathClassLoaderExtendsClassLoader.packageName = "com.core.io";
            Class<?> myClass = pathClassLoaderExtendsClassLoader.loadClass("com.core.io.ReadFiletFromOS");
            System.out.println(myClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
