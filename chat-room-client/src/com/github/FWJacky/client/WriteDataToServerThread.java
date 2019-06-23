package com.github.FWJacky.client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ClassName WriteDataToServerThread
 * @Description TODO
 * @Author L
 * @Date 2019/6/23 18:18
 * @Version 1.0
 **/
public class WriteDataToServerThread extends Thread{

    private final Socket socket;

    public WriteDataToServerThread(Socket socket) {
        this.socket=socket;
    }

    @Override
    public void run() {
        try {
            OutputStream out = socket.getOutputStream();
            PrintStream printStream = new PrintStream(out);
            //客户端从键盘输入
            Scanner scanner = new Scanner(System.in);
            //一直发送数据，知道用户下线
            while(true) {
                System.out.print("请输入>");
                String message = scanner.nextLine();
                printStream.println(message);
                printStream.flush();
                //用户退出
                if(message.equals("byte")) {
                    break;
                }
            }
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
