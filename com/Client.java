import java.util.Scanner;

/**
 * @ClassName Client
 * @Description TODO
 * @Author L
 * @Date 2019/4/9 19:40
 * @Version 1.0
 **/
public class Client {
    public void buyComputer(Computer computer) {
        computer.printComputer();
    }

    public static void main(String[] args) {
        System.out.println("请输入一个你想要的电脑类型：MAC SUR MI ALI");
        Client client = new Client();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        client.buyComputer(ComputerFactory.getComputer(str));
//        client.buyComputer(new SurfaceBookComputer());
//        client.buyComputer(new MacbookProComputer());
    }
}
