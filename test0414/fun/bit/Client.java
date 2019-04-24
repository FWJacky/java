package fun.bit;

import java.util.Scanner;

public class Client  {
    public void buyPhone(Phone phone) {
        phone.printPhone();
    }
    public Phone select(String str) {
        if(str.equals("苹果")) {
            return new IphoneFactory().createPhone();
        }else {
            return new HuaWeiFactory().createPhone();
        }
    }
    public static void main(String[] args) {
        System.out.println("请输入你想要的手机：苹果 or 华为");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Client client = new Client();
        client.buyPhone(client.select(str));
    }
}

