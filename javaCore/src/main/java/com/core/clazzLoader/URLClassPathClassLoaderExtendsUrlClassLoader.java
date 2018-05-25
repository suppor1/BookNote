package com.core.clazzLoader;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by jiangkai
 * Date 2018/5/12
 */
public class URLClassPathClassLoaderExtendsUrlClassLoader extends URLClassLoader {
    private String packageName = "com.you.package.name";

    public URLClassPathClassLoaderExtendsUrlClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> classObject = findLoadedClass(name);
        if(null != classObject){
            return classObject;
        }
        if(!packageName.startsWith(name)){
            return super.loadClass(name);
        }else {
            Class<?> classObject_ = findClass(name);
            return classObject_;
        }
    }
}
