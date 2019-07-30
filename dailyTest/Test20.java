package com.github.dailyTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Test20
 * @Description TODO
 * @Author L
 * @Date 2019/7/9 12:43
 * @Version 1.0
 **/
public class Test20 {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int n = in.nextInt();
            if (n > 1000) {
                n = 999;
            }
            for (int i = 0; i < n; i++) {
                a.add(i);
            }
            int i = 0;
            while (a.size() > 1) {
                i = (i + 2) % a.size();
                a.remove(i);
            }
            System.out.println(a.get(0));
        }
    }
}
