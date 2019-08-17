package dailyTest;

import java.util.Scanner;

/**
 * @ClassName Test89
 * @Description TODO   删除公共字符串
 * @Author L
 * @Date 2019/8/17 10:49
 * @Version 1.0
 **/
public class Test89 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            StringBuilder firstStr = new StringBuilder(sc.nextLine());
            String secondStr = sc.nextLine();
            for (int i = 0; i < secondStr.length(); i++) {
                for (int j = 0; j < firstStr.length(); j++) {
                    if(secondStr.charAt(i) == firstStr.charAt(i)) {
                        firstStr.deleteCharAt(j);
                        j--;
                    }
                }
            }
            System.out.println(firstStr.toString());
        }
    }
}
