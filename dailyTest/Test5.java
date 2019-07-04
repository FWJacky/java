import java.util.Scanner;

/**
 * @ClassName Test5
 * @Description TODO
 * @Author L
 * @Date 2019/7/2 12:53
 * @Version 1.0
 **/
public class Test5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nullP = 0;
        int drinkNum = 0;
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (n < 1 || n>100) {
                return;
            }
            nullP = n;
            int num = 0;
            while (true) {
                drinkNum = nullP / 3; //27  nullP = 81
                num += drinkNum; //27 //4
                nullP = drinkNum + nullP % 3;  //27
                if (nullP == 2) {
                    num++;
                    break;
                } else if (nullP == 1 || nullP == 0) {
                    break;
                }
            }
            System.out.println(num);
        }
    }
}
