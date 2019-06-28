package com.guyw.study.web;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

public class SocketClientTest extends TestCase {
    ExecutorService            service = Executors.newFixedThreadPool(2);

    public static final String IP      = "localhost";                    // 服务器地址
    public static final int    PORT    = 8000;                           // 服务器端口号

    private int handler() {
        try {
            // 实例化一个Socket，并指定服务器地址和端口
            Socket client = new Socket(IP, PORT);
            // 开启两个线程，一个负责读，一个负责写
            new Thread(new ClientReadThread(client)).start();
            new Thread(new ClientWriteThread(client)).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    /**
     * 处理读操作的线程
     */
    class ClientReadThread implements Runnable {
        private Socket client;

        public ClientReadThread(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            DataInputStream dis = null;
            try {
                while (true) {
                    // 读取客户端数据
                    dis = new DataInputStream(client.getInputStream());
                    String reciver = dis.readUTF();
                    System.out.println("服务器端返回过来的是:" + reciver);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (dis != null) {
                        dis.close();
                    }
                    if (client != null) {
                        client = null;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 处理写操作的线程
     */
    class ClientWriteThread implements Runnable {
        private Socket client;

        public ClientWriteThread(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            DataOutputStream dos = null;
            BufferedReader br = null;
            try {
                while (true) {
                    // 向客户端回复信息
                    dos = new DataOutputStream(client.getOutputStream());
                    System.out.print("客户端请输入:\r");
                    // 键盘录入
                    br = new BufferedReader(new InputStreamReader(System.in));
                    String send = br.readLine();
                    // 发送数据
                    dos.writeUTF(send);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (dos != null) {
                        dos.close();
                    }
                    if (br != null) {
                        br.close();
                    }
                    if (client != null) {
                        client = null;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void test() throws InterruptedException {

        SocketClientTest client = new SocketClientTest();
        client.handler();
        System.out.println("");

    }

}
