package com.bit.src;


import java.util.Scanner;

public class Client {
    //创建买电脑的方法
    public void buyComputer(Computer computer) {
        computer.printComputer();
    }
    //选择电脑品牌
    public Computer select(String str) {
        if(str.equals("Mac")) {
            return new MacbookProComputer();
        }else {
            return  new SurfaceBookComputer();
        }
    }
    public static void main(String[] args) {
        System.out.println("请输入你想要的电脑品牌：Mac or Surface");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Client client = new Client();
        client.buyComputer(client.select(str));
    }
}

