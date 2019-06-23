package com.github.FWJacky.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName MultiThreadServer
 * @Description TODO
 * @Author L
 * @Date 2019/6/23 17:40
 * @Version 1.0
 **/
public class MultiThreadServer {

    private final Socket socket;

    public MultiThreadServer(Socket socket) {
        this.socket = socket;
    }

    public static void main(String[] args) {

        int port = 4406;
        final ExecutorService executorService = Executors.newFixedThreadPool(2*Runtime.getRuntime().availableProcessors());


        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("服务器启动，运行在："+serverSocket.getLocalSocketAddress());
            //保证能一直连接客户端
            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("客户端连接：" + socket.getLocalSocketAddress());
                executorService.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }

}
