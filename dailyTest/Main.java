import java.util.Scanner;

/**
 * @ClassName Main
 * @Description TODO
 * @Author L
 * @Date 2019/7/4 10:10
 * @Version 1.0
 **/
public class Main {

    public static int buyApple(int n) {

        int[] count = new int[4];
        int index = 0;
        if (n < 1 || n > 100 || n % 2 != 0) {
            return -1;
        }
        for (int i = 0; i <= n/6; i++) {
            for (int j = 0; j <= n/8; j++) {
                if ((i * 6 + j * 8) == n) {
                    count[index++] = i + j;
                }
            }
        }
        if(count[1]==0 && count[0]!=0) {
            return count[0];
        }else if(count[1]<count[0]) {
            return count[1];
        }else {
            return count[0];
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int rs = buyApple(n);
        System.out.println(rs);
    }
}
