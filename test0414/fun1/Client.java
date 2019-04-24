package fun1;

import java.util.Scanner;

public class Client {
    public void buyPhone(Phone phone) {
        phone.printPhone();
    }
    public void use(OperatingSystem operatingSystem) {
        operatingSystem.printSystem();
    }
//    public fun1.Phone select(String str) {
//        if(str.equals("苹果手机")) {
//            return new fun1.Iphone();
//        }else {
//            return new fun1.HuaWei();
//        }
//    }
    //上一段方法可写成
    	public Phone select(String str) {
    		if(str.equals("苹果")) {
    			return new IphoneFactory().createPhone();
    		}else {
    			return new HuaWeiFactory().createPhone();
    		}
    	}
//    public fun1.OperatingSystem selectSystem(String str) {
//        if(str.equals("苹果手机")) {
//            return new fun1.IphoneSystem();
//        }else {
//            return new fun1.AndroidSystem();
//        }
//    }
//    上一段方法可写成
    	public OperatingSystem selectSystem(String str) {
    		if(str.equals("苹果")) {
    			return new IphoneFactory().createSystem();
    		}else {
    			return new HuaWeiFactory().createSystem();
    		}
    	}
    public static void main(String[] args) {
        System.out.println("请输入你想要的手机：苹果 or 华为");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Client client = new Client();
        client.buyPhone(client.select(str));
        client.use(client.selectSystem(str));
    }
}


