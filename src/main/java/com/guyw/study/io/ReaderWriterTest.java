package com.guyw.study.io;


import junit.framework.TestCase;

import java.io.*;

public class ReaderWriterTest extends TestCase {



    public void testReader() throws Exception {

        // 第1步、使用File类找到一个文件
        File f= new File("/Users/conangu/java/code/study/src/main/java/com/guyw/study/io/ReaderWriterTest.java") ;    // 声明File对象
        // 第2步、通过子类实例化父类对象
        Reader input = null ;    // 准备好一个输入的对象
        input = new FileReader(f)  ;    // 通过对象多态性，进行实例化
        // 第3步、进行读操作
        int size  = (int) f.length();
        char c[] = new char[size] ;        // 所有的内容都读到此数组之中
        int len = input.read(c) ;        // 读取内容
        // 第4步、关闭输出流
        input.close() ;                        // 关闭输出流
        System.out.println("内容为：" + new String(c,0,len)) ;    // 把字符数组变为字符串输出

    }

    public void testWriter() throws Exception{
        // 第1步、使用File类找到一个文件
        File f= new File("/Users/conangu/java/code/study/src/main/java/com/guyw/study/io/BufferReaderWriterTest.java") ;    // 声明File对象
        // 第2步、通过子类实例化父类对象
        Writer out = null ;    // 准备好一个输出的对象
        out = new FileWriter(f,true)  ;    // 实例化
        // 第3步、进行写操作
        String str = "//Hello World!!!" ;        // 准备一个字符串
        out.write(str) ;        // 写入数据
        // 第4步、关闭输出流
        out.close() ;                        // 关闭输出流

    }
}
