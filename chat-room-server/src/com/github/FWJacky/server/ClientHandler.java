package com.github.FWJacky.server;

import jdk.internal.util.xml.impl.Input;
import jdk.jfr.events.SocketReadEvent;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @ClassName ClientHandler
 * @Description TODO
 * @Author L
 * @Date 2019/6/23 17:41
 * @Version 1.0
 **/
public class ClientHandler implements Runnable {

    //定义一个静态的final的Map来保存客户端的用户名以及对应的用户端Socket
    //此处为什么要用static final修饰？
    //是为了能够在类的内部调用socketMap，不然要通过对象调用
    private static final Map<String, Socket> socketMap = new ConcurrentHashMap<>();

    private final Socket client;

    private String name;

    public ClientHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            //从客户端获取输入的信息
            InputStream in = this.client.getInputStream();
            Scanner scanner = new Scanner(in);
            //一直读取客户端传入的数据
            while (true) {
                //从客户端按行获取数据，如果放在while循环外，则会死循环，获取不到下一次客户端传入的数据
                String line = scanner.nextLine();
                //如果客户端输入的数据是以register:开头，则表示服务器端完成注册服务
                if (line.startsWith("register:")) {
                    //将客户端输入的信息进行拆分
                    String[] segments = line.split(":");
                    //如果拆分后的数组长度满足要求，则将第二部分name进行注册
                    if (segments.length == 2 && segments[0].equals("register")) {
                        String name = segments[1];
                        register(name);
                    }
                    continue;
                }
                //如果客户端输入的数据是以groupChat:开头，则表示服务器端完成群聊服务
                if (line.startsWith("groupChat:")) {
                    //将客户端输入的信息进行拆分
                    String[] segments = line.split(":");
                    //如果拆分后的数组长度满足要求，则将第二部分name进行注册
                    if (segments.length == 2 && segments[0].equals("groupChat")) {
                        String message = segments[1];
                        groupChat(message);
                    }
                    continue;
                }
                //如果客户端输入的数据是以privateChat:开头，则表示服务器端完成私聊服务
                if(line.startsWith("privateChat:")) {
                    //将客户端输入的信息进行拆分
                    String[] segments = line.split(":");
                    //如果拆分后的数组长度满足要求，则将第二部分name进行注册
                    if (segments.length == 3 && segments[0].equals("privateChat")) {
                        String name = segments[1];
                        String message = segments[2];
                        privateChat(name,message);
                    }
                    continue;
                }
                //如果客户端输入的数据是以bye开头，则表示服务器端完成退出群聊服务
                if(line.equalsIgnoreCase("bye")) {
                    quit();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void quit() {
        socketMap.remove(this.name);
        System.out.println(this.name +" 退出群聊");
        printOnline();
    }

    private void privateChat(String name, String message) {
        Socket socket = socketMap.get(name);
        sendMessage(socket,this.name+"说："+message);
    }

    //给所有群组中的所有用户发送信息，除了发送者
    private void groupChat(String message) {
        for (Map.Entry<String,Socket> entry : socketMap.entrySet()) {
            Socket socket = entry.getValue();
            if(socket != this.client) {
                sendMessage(socket,this.name +"说："+ message);
            }
        }
    }

    //注册服务
    private void register(String name) {
        this.name = name;
        //将注册信息加载到Map中，对应的是用户名-客户端
        socketMap.put(name, this.client);
        System.out.println(name+"加入群聊");
        sendMessage(this.client,"欢迎，"+name+"注册成功");
        //打印当前在线的用户
        printOnline();
    }

    //服务器端发送数据
    private void sendMessage(Socket socket, String message) {
        try {
            OutputStream out = socket.getOutputStream();
            PrintStream printStream = new PrintStream(out);
            printStream.println(message);
            printStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printOnline() {
        System.out.println("当前在线用户有：" + socketMap.size() + "个，用户列表如下：");
        for (String name : socketMap.keySet()) {
            System.out.println(name);
        }
    }
}
