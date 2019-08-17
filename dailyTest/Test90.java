package dailyTest;

import java.util.Scanner;

/**
 * @ClassName Test90
 * @Description TODO   句子逆序
 * @Author L
 * @Date 2019/8/17 10:55
 * @Version 1.0
 **/
public class Test90 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] worlds = str.split(" ");
            for (int i = worlds.length-1; i >= 0 ; i--) {
                System.out.print(worlds[i]+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}
