package com.bit;

import java.util.Scanner;

/**
 * @ClassName Client
 * @Description TODO
 * @Author L
 * @Date 2019/4/11 16:14
 * @Version 1.0
 **/
public class Client {
    public void buy(Computer computer) {
        computer.printComputer();
    }
    public Computer selectComputer() {
        System.out.println("请输入你想购买的电脑：苹果 or 微软");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str.equals("苹果")){
            return new MacbookProComputer();
        }
        return new SurfaceBookComputer();
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.buy(client.selectComputer());
    }
}
