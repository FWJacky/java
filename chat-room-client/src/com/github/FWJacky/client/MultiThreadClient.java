package com.github.FWJacky.client;

import java.io.IOException;
import java.net.Socket;

/**
 * @ClassName MulitThreadClient
 * @Description TODO
 * @Author L
 * @Date 2019/6/23 17:39
 * @Version 1.0
 **/
public class MultiThreadClient {

    public static void main(String[] args) {
        String ip = "127.0.0.1";
        int port = 4406;

        //客户端只需要进行发送数据和接收数据的操作就行
        try {
            Socket socket = new Socket(ip,port);
            //通过线程来实现对服务器发送数据
            new WriteDataToServerThread(socket).start();
            //通过线程来实现接收服务器数据
            new ReadDataFromServerThread(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
