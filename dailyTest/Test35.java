package com.github.dailyTest;

import java.util.Scanner;

/**
 * @ClassName Test34
 * @Description TODO
 * @Author L
 * @Date 2019/7/16 11:21
 * @Version 1.0
 **/
public class Test35 {
    public static String GetSequeOddNum(int m) {
        String str = "";
        if (m % 2 != 0) {
            for (int i = 0; i < m; i++) {
                int midNum = m * m;
                if (i <= m / 2) {
                    int left = midNum - 2 * (m / 2 - i);
                    str += left + "+";
                } else if (i == m / 2) {
                    str += midNum + "+";
                } else {
                    int right = midNum + 2 * (i - m / 2);
                    str += right + "+";
                }
            }
        } else {
            for (int i = 0; i < m; i++) {
                int midNum = m * m;
                if (i < m / 2) {
                    int left = (midNum - 1) - 2 * (m / 2 - i - 1);
                    str += left + "+";
                } else {
                    int right = (midNum + 1) + 2 * (i - m / 2);
                    str += right + "+";
                }
            }
        }
        return str.substring(0, str.length() - 1);
    }

    public static String GetSequeOddNum2(int m) {
        StringBuilder str = new StringBuilder();
        int startNum = m * m + 1 - m;
        str.append(String.valueOf(startNum));
        for (int i = 1; i < m; i++) {
            str.append("+").append(String.valueOf(startNum + 2 * i));
        }
        return str.toString();
    }

    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            while(in.hasNextInt()) {
                int m = in.nextInt();
                StringBuilder str = new StringBuilder();
                int startNum = m * m + 1 - m;
                str.append(String.valueOf(startNum));
                for (int i = 1; i < m; i++) {
                    startNum = startNum + 2;
                    str.append("+");
                    str.append(String.valueOf(startNum));
                }
                System.out.println(str.toString());
            }
            in.close();
        }
}
