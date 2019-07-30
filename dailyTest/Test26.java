package com.github.dailyTest;

import java.util.Scanner;

/**
 * @ClassName Test26
 * @Description TODO
 * @Author L
 * @Date 2019/7/11 16:29
 * @Version 1.0
 **/
public class Test26 {
    private static int count;

    public static void countWays(int x, int y) {
        // write code here

        int num = x + y - 2;
        int num2 = y - 1;
        int n = num;
        int m = num2;
        for (int i = 1; i < y - 1; i++) {
            n *= (--num);
            m *= (--num2);
        }
        int rs = n / m;
        System.out.println(rs);
    }

    //    public static void main(String[] args) {
//        countWays(4, 2);
//    //        System.out.println(count);
//    }
    String str = new String("good");
    char[] ch = {'a', 'b', 'c'};

//    public static void main(String args[]) {
//        Test26 ex = new Test26();
//        ex.change(ex.str, ex.ch);
//        System.out.print(ex.str + " and ");
//        System.out.print(ex.ch);
//    }

    public void change(String str, char ch[]) {
        //引用类型变量，传递的是地址，属于引用传递。
        str = "test ok";
        ch[0] = 'g';
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            String[] strs = str.split(" ");
            int[] arr = new int[strs.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.valueOf(strs[i]);
            }
            int num = arr[0];
            int count = 0;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] == num) {
                    count++;
                } else if (count > 0) {
                    count--;
                } else {
                    num = arr[j];
                }
            }
            System.out.println(num);
        }
    }


}





