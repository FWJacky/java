package com.github.dailyTest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Test44
 * @Description TODO
 * @Author L
 * @Date 2019/7/21 23:28
 * @Version 1.0
 **/
public class Test44 {

    public static boolean[] chkSubStr(String[] p, int n, String s) {
        // write code here
        boolean[] result = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(s.contains(p[i])) {
                result[i] = true;
            }else {
                result[i] = false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] p = new String[]{"a","b","c","d"};
        int n = 4;
        String s = "abc";
        System.out.println(Arrays.toString(chkSubStr(p, n, s)));

    }
}
