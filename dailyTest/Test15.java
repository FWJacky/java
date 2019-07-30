package com.github.dailyTest;

import java.util.Scanner;

/**
 * @ClassName Test15
 * @Description TODO
 * @Author L
 * @Date 2019/7/8 9:33
 * @Version 1.0
 **/
public class Test15 {
    public static int cake(int a,int b) {
        int count = 0;
       if(a%4==0 || b%4==0) {
           count = a*b/2;
       }else if(a%2 == 0 && b%2 == 0) {
           count = ((a*b)/3)*2;
       }else {
           count = (a*b/2)+1;
       }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int a = in.nextInt();
            int b = in.nextInt();
            int rs =cake(a, b);
            System.out.println(rs);
        }
        in.close();
    }
}
