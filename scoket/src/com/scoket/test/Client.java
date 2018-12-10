package com.scoket.test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author yufei
 * @create 2018-12-09 20:14
 */
public class Client {

    public void scoketClient() {
        Socket socket = null;
        try {
            socket = new Socket(InetAddress.getLocalHost(),1234);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("你好我是客户端！！！".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void serviceSocket() {
        ServerSocket socket = null;
        try {
            socket = new ServerSocket(1234);

            Socket accept = socket.accept();
            InputStream inputStream = accept.getInputStream();
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(isr);
            System.out.println("服务器启动了开发读取客户端发来的数据:"+br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
