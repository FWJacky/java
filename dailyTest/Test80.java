package dailyTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @ClassName Test80
 * @Description TODO
 * @Author L
 * @Date 2019/8/11 21:57
 * @Version 1.0
 **/
public class Test80 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = scanner.nextInt();
                arr[i][1] = scanner.nextInt();
            }
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (arr[i][0] == 1) {
                    list.add(arr[i][1]);
                } else {
                    list.remove(new Integer(arr[i][1]));
                }
                if(judge(list)) {
                    System.out.println("Yes");
                }else {
                    System.out.println("No");
                }
            }
        }
    }

    public static boolean judge(ArrayList<Integer> list) {
        int len = list.size();
        Collections.sort(list);
        if (len < 3) {
            return false;
        }
        int maxL = list.get(len - 1);
        int sumL = 0;
        for (int i = 0; i < len - 1; i++) {
            sumL += list.get(i);
        }
        if(sumL > maxL) {
            return true;
        }else {
            return false;
        }
    }
}
