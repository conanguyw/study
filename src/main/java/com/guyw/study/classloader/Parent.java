package com.guyw.study.classloader;

import sun.reflect.Reflection;

/**
 * @author conangu
 * @createTime 2019-06-27 15:44
 * @description test
 */
public class Parent {


    public ClassLoader a(){

        return Reflection.getCallerClass(2).getClassLoader();
    }

}
