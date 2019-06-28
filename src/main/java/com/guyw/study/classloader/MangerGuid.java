package com.guyw.study.classloader;

/**
 * @author conangu
 * @createTime 2019-06-27 16:34
 * @description test
 */
public class MangerGuid {
 private Parent parent;
    public ClassLoader m(){
        Parent parent = new Parent();
     return parent.a();
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
}
