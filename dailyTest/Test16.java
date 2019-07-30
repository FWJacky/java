package com.github.dailyTest;

import java.util.Scanner;

/**
 * @ClassName Test16
 * @Description TODO
 * @Author L
 * @Date 2019/7/8 9:49
 * @Version 1.0
 **/
public class Test16 {

    public static int maxCommonNum(int a,int b) {

        int s = a%b;
        a = b;
        if(s==0) {
            return b;
        }
        return maxCommonNum(a,s);


    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int a = in.nextInt();
            int b = in.nextInt();
            int x = maxCommonNum(a,b);
            int rs = (a*b)/x;
            System.out.println(rs);
        }
        in.close();
    }
}
