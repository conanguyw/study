package com.guyw.study;

import com.guyw.study.classloader.MangerGuid;
import com.guyw.study.classloader.MyClassLoader;
import com.guyw.study.classloader.Parent;
import org.apache.commons.lang3.StringUtils;
import sun.reflect.Reflection;

import java.lang.reflect.Method;
import java.net.URLClassLoader;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

/**
 * @author conangu
 * @createTime 2019-05-31 19:04
 * @description test
 */
public class NormalTest {
    public static void main(String args[]) throws Exception{

        String a =String.valueOf(12);
        System.out.println(a.intern() =="12");

        Integer.valueOf(1);

        HashSet set = new HashSet();
        set.add("1");
        HashMap hashMap = new HashMap();
        hashMap.put("","");
        hashMap.get("");
        Parent parent =new Parent();
        System.out.println(parent.a());



        long time =new Date().getTime();

        TimeUnit.SECONDS.sleep(1);
        long time2 =new Date().getTime();

        System.out.println((time-time2)/1000);



    }
}
