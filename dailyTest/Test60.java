package dailyTest;

import java.util.Scanner;

/**
 * @ClassName Test60
 * @Description TODO
 * @Author L
 * @Date 2019/7/31 11:27
 * @Version 1.0
 **/
public class Test60 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String n = in.nextLine();
            String[] arr = in.nextLine().split(" ");
            String x = in.next();
            for (int i = 0; i < arr.length; i++) {
                if(x.equals(arr[i])) {
                    System.out.println(i);
                    return;
                }
            }
            System.out.println(-1);
        }
        in.close();
    }
}
