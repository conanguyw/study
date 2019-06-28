package com.guyw.study.classloader;

import java.lang.reflect.Method;
import java.net.URLClassLoader;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import sun.misc.Launcher;
import sun.reflect.Reflection;

/**
 * @author conangu
 * @createTime 2019-05-31 19:04
 * @description test
 */
public class ClassLoadTest {
    public static void main(String args[]) throws Exception{
        //Reflection.getCallerClass(2)的漏洞
        MyClassLoader myClassLoader = new MyClassLoader(((URLClassLoader)Reflection.getCallerClass(1).getClassLoader()).getURLs());
        Class manger =myClassLoader.findClass("com.guyw.study.classloader.MangerGuid");
        Object m = manger.newInstance();
        System.out.println(  manger.getMethod("m").invoke(m)      );
        MangerGuid mangerGuid  = new MangerGuid();
        System.out.println( mangerGuid.m()    );

    }
}
