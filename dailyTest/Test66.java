package dailyTest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Test66
 * @Description TODO  奇偶校验
 * @Author L
 * @Date 2019/8/4 19:31
 * @Version 1.0
 **/
public class Test66 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            oddEvenCheck(str.toCharArray());
        }
    }

    public static void oddEvenCheck(char[] chars) {
        int[] rs = new int[8];
        for (int i = 0; i < chars.length; i++) {
            int x = 1;
            int j = 7;
            int count = 0;
            while(j > 0) {
                rs[j] = (chars[i] & x) == 0 ? 0 : 1;
                if(rs[j]==1) {
                    count++;
                }
                x = x << 1;
                j--;
            }
            if(count%2==0) {
                rs[0] = 1;
            }else {
                rs[0] = 0;
            }
            for (int k = 0; k < rs.length; k++) {
                System.out.print(rs[k]);
            }
            System.out.println();
        }
    }
}
