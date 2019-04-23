import java.io.StringReader;
import java.util.Scanner;

/**
 * @ClassName Client
 * @Description TODO
 * @Author L
 * @Date 2019/4/13 14:22
 * @Version 1.0
 **/
public class Client {
    public  void buyComputer(Computer computer) {
        computer.printComputer();
    }
    public void use(OperatingSystem operatingSystem) {
        operatingSystem.printSystem();
    }
    public Computer select(String str) {

        if(str.equals("苹果电脑")) {
            return new AppleFactory().createComputer();
        }else {
            return new MsFactory().createComputer();
        }
    }
    public OperatingSystem selectSystem(String str) {
        if(str.equals("苹果电脑")) {
            return new AppleFactory().createSystem();
        }else {
            return new MsFactory().createSystem();
        }
    }

    public static void main(String[] args) {
        System.out.println("请输入你想要的电脑：苹果电脑 or 微软电脑");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Client client = new Client();
//        client.select();
        client.buyComputer(client.select(str));
        client.use(client.selectSystem(str));
//        ComputerFactory computerFactory = new AppleFactory();
//        OperatingSystem operatingSystem = computerFactory.createSystem();
//        client.buyComputer(computerFactory.createComputer());
//        client.use(computerFactory.createSystem());
    }
}
