package com.guyw.study.io;


import junit.framework.TestCase;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class NIOTest extends TestCase {



    public void testIn() throws Exception {

        FileInputStream fin = new FileInputStream("/Users/conangu/java/code/study/src/main/java/com/guyw/study/io/NIOTest.java");

        // 获取通道
        FileChannel fileChannel = fin.getChannel();

        // 创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        CharBuffer charBuffer = CharBuffer.allocate(1024);//中文用char
        // 读取数据到缓冲区
        Charset charset = Charset.forName("utf-8");
        CharsetDecoder decoder = charset.newDecoder();

        int bytes = fileChannel.read(byteBuffer);
        while(bytes!=-1){
            byteBuffer.flip();
            decoder.decode(byteBuffer, charBuffer, false);
            charBuffer.flip();

            System.out.println(charBuffer);
            charBuffer.clear();
            byteBuffer.clear();
            bytes = fileChannel.read(byteBuffer);
        }
        if(fin!=null){
            fin.close();
        }

    }
}
