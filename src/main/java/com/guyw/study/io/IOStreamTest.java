package com.guyw.study.io;


import junit.framework.TestCase;

import java.io.*;

public class IOStreamTest extends TestCase {



    public void testInput() throws Exception {

        // 第1步、使用File类找到一个文件
        File f= new File("/Users/conangu/java/code/study/src/main/java/com/guyw/study/io/IOStreamTest.java") ;    // 声明File对象
        // 第2步、通过子类实例化父类对象
        InputStream input = null ;    // 准备好一个输入的对象
        input = new FileInputStream(f)  ;    // 通过对象多态性，进行实例化
        // 第3步、进行读操作
        // 数组大小由文件决定
        int size = (int) f.length();
        byte[] b = new byte[size];
        int len = 0 ;
        int temp = 0 ;            // 接收每一个读取进来的数据
        while((temp=input.read())!=-1){
            // 表示还有内容，文件没有读完
            b[len] = (byte)temp ;
            len++ ;
        }
        // 第4步、关闭输出流
        input.close() ;                        // 关闭输出流\
        System.out.println("内容为：" + new String(b,0,len)) ;    // 把byte数组变为字符串输出
    }

    public void testOutput() throws Exception{
        // 第1步、使用File类找到一个文件
        File f= new File("/Users/conangu/java/code/study/src/main/java/com/guyw/study/io/BufferIOStreamTest.java") ;    // 声明File对象
        // 第2步、通过子类实例化父类对象
        OutputStream out = null ;    // 准备好一个输出的对象
        out = new FileOutputStream(f,true)  ;    // 实例化
        // 第3步、进行写操作
        String str = "//Hello World!!!" ;        // 准备一个字符串
        byte b[] = str.getBytes() ;            // 只能输出byte数组，所以将字符串变为byte数组
        out.write(b) ;        // 写入数据
        // 第4步、关闭输出流
         out.close() ;                        // 关闭输出流

    }


}
