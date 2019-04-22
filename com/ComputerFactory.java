import java.util.Scanner;

/**
 * @ClassName ComputerFactory
 * @Description TODO
 * @Author L
 * @Date 2019/4/9 20:07
 * @Version 1.0
 **/
public class ComputerFactory {
        public static Computer getComputer(String str) {
            Computer computer = null;
            switch (str) {
                case "MAC":
                    computer = new MacbookProComputer();   //向上转型
                    break;
                case "SUR":
                    computer = new SurfaceBookComputer();
                    break;
                case "MI":
                    computer = new MiBookComputer();
                    break;
                case "ALI":
                    computer = new AlienBookComputer();
                    break;
                default:
                    System.out.println("请输入正确的电脑型号：MAC SUR MI ALI");
            }
            return computer;
        }
}
