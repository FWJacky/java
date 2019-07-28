package com.github.dailyTest;

import java.util.Scanner;

/**
 * @ClassName Test23
 * @Description TODO
 * @Author L
 * @Date 2019/7/10 11:27
 * @Version 1.0
 **/
public class Test23 {
    StringBuilder a = new StringBuilder("A");
    StringBuilder b = new StringBuilder("B");
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int num = in.nextInt();
//        String nums = String.valueOf(num);
//        StringBuilder sb = new StringBuilder(nums);
//        StringBuilder reverseNum = sb.reverse();
//        System.out.println(reverseNum);
//        Object o = new Object(){
//            @Override
//            public boolean equals(Object obj) {
//                return true;
//            }
//        };
//        System.out.println(o.equals("Fred"));
        Test23 test23 = new Test23();
        opera(test23.a, test23.b);
        System.out.println(test23.a+" "+test23.b);

    }


    public static void opera(StringBuilder x,StringBuilder y) {
        x.append(y);
        y = x;
    }

}
