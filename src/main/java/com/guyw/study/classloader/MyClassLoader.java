package com.guyw.study.classloader;

import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

/**
 * @author conangu
 * @createTime 2019-06-27 17:18
 * @description 类加载器
 */
public class MyClassLoader  extends URLClassLoader {


    public Class<?> findClass(String name) throws ClassNotFoundException {

            return super.findClass(name);

    }

    public MyClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public MyClassLoader(URL[] urls) {
        super(urls);
    }

    public MyClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(urls, parent, factory);
    }
}
