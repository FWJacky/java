package dailyTest;

import java.util.Scanner;

/**
 * @ClassName Test62
 * @Description TODO  守形数
 * @Author L
 * @Date 2019/8/1 22:19
 * @Version 1.0
 **/
public class Test62 {

    public static void keepShapeNum(int num) {
        int doubleNum = num * num;
        StringBuilder sb = new StringBuilder(String.valueOf(doubleNum));
        String str = String.valueOf(num);
        if(sb.substring(sb.length()-str.length()).equals(str)) {
            System.out.println("Yes!");
        }else {
            System.out.println("No!");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int num = Integer.parseInt(in.nextLine());
            keepShapeNum(num);
        }
        in.close();
    }
}
