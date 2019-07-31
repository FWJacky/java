package dailyTest;

import java.util.Scanner;

/**
 * @ClassName Test58
 * @Description TODO
 * @Author L
 * @Date 2019/7/31 10:57
 * @Version 1.0
 **/
public class Test58 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String n = in.nextLine();
            String suqareNum = String.valueOf((int)Math.pow(Integer.parseInt(n), 2));
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < n.length(); i++) {
                sum1 += Integer.parseInt(String.valueOf(n.charAt(i)));
            }
            for (int i = 0; i < suqareNum.length(); i++) {
                sum2 += Integer.parseInt(String.valueOf(suqareNum.charAt(i)));
            }
            System.out.println(sum1 + " " + sum2);
        }
        in.close();
    }
}
