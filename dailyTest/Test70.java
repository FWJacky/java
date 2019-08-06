package dailyTest;

import java.util.Scanner;

/**
 * @ClassName Test70
 * @Description TODO  在霍格沃茨找零钱
 * @Author L
 * @Date 2019/8/6 10:38
 * @Version 1.0
 **/
public class Test70 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] trans = new int[]{17 * 19, 19, 1};
        while (scanner.hasNext()) {
            String[] p = scanner.next().split("\\.");
            String[] A = scanner.next().split("\\.");
            int[] pMoney = {Integer.parseInt(p[0]), Integer.parseInt(p[1]), Integer.parseInt(p[2])};
            int[] aMoney = {Integer.parseInt(A[0]), Integer.parseInt(A[1]), Integer.parseInt(A[2])};
            int sumP = pMoney[0] * trans[0] + pMoney[1] * trans[1] + pMoney[2] * trans[2];
            int sumA = aMoney[0] * trans[0] + aMoney[1] * trans[1] + aMoney[2] * trans[2];
            int result = sumA - sumP;
            if (sumA < sumP) {
                System.out.print("-");
                result = -result;
            }
            System.out.println(result / trans[0] + "." + result % trans[0] / trans[1] + "." + result % trans[0] % trans[1] / trans[2]);
        }
        scanner.close();
    }
}
