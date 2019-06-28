package com.guyw.study.io;

import junit.framework.TestCase;

import java.io.*;

public class BufferIOStreamTest extends TestCase {

    public void testInput() throws Exception {

        try (FileInputStream fis = new FileInputStream("/Users/conangu/java/code/study/src/main/java/com/guyw/study/io/BufferIOStreamTest.java");
                BufferedInputStream bis = new BufferedInputStream(fis);) {

            int c = 0;
            //在输入流中的当前位置上作标记。
            //reset 方法的后续调用将此流重新定位在最后标记的位置上，以便后续读取操作重新读取相同的字节。
            //            bis.mark(104);
            for (int i = 0; (c = bis.read()) != -1; i++) {
                System.out.print((char) c + "");
            }

//            System.out.println();
            //将此流重新定位到对此输入流最后调用 mark 方法时的位置。
            //            bis.reset();
            //            for(int i=0;i<10 && (c=bis.read())!=-1;i++){
            //                System.out.print((char)c+" ");
            //            }
        }
    }

    public void testOutput() throws Exception {
        // 第1步、使用File类找到一个文件
        File f = new File("/Users/conangu/java/code/study/src/main/java/com/guyw/study/io/IOStreamTest.java"); // 声明File对象
        // 第2步、通过子类实例化父类对象
        OutputStream out = new FileOutputStream(f,true); // 实例化

        BufferedOutputStream bos = new BufferedOutputStream(out);

        // 第3步、进行写操作
        String str = "//Hello World!!!"; // 准备一个字符串
        byte b[] = str.getBytes(); // 只能输出byte数组，所以将字符串变为byte数组
        bos.write(b); // 写入数据
        
        // 第4步、关闭输出流
        bos.close(); // 关闭输出流

    }
}
//Hello World!!!