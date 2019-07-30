package dailyTest;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;

/**
 * @ClassName Teste53
 * @Description TODO
 * @Author L
 * @Date 2019/7/27 11:56
 * @Version 1.0
 **/
public class Test54 {

    // 获得最大公约数 ---- 辗转相除法
    public static int commonDiv(int a,int b) {
        int temp = 0;
        if(a < b) {
            temp = a;
            a = b;
            b = temp;
        }
        while (a%b != 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            int a = in.nextInt();
            int[] monster = new int[n];
            for (int i = 0; i < n; i++) {
                monster[i] = in.nextInt();
            }
            for (int i = 0; i < monster.length; i++) {
                if(a >= monster[i]) {
                    a += monster[i];
                }
                if(a < monster[i]) {
                    a += commonDiv(a, monster[i]);
                }
            }
            System.out.println(a);
        }
    }
}
