package com.github.FWJacky.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @ClassName ReadDataFromServerThread
 * @Description TODO
 * @Author L
 * @Date 2019/6/23 18:18
 * @Version 1.0
 **/
public class ReadDataFromServerThread extends Thread{

    private final Socket socket;

    public ReadDataFromServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream in = socket.getInputStream();
            Scanner scanner = new Scanner(in);
            //一直读取客户端的数据
            while(true) {
                try {
                    String message = scanner.nextLine();
                    System.out.println("来自服务器>" + message);
                }catch (NoSuchElementException e){
                    break;
                }
            }
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
