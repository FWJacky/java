package com.github.dailyTest;

import java.util.*;

/**
 * @ClassName Test40
 * @Description TODO   火车进站问题
 * @Author L
 * @Date 2019/7/18 21:03
 * @Version 1.0
 **/


public class Test40 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            ArrayList<int[]> result = new ArrayList<>();
            // 得到全排列
            fullArray(a,0,n,result);
            // sortResult用来存放合法的情况
            Set<String> sortResult = new TreeSet<>();
            for (int[] out : result) {
                if(isLegal(a,out,n)) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < n-1; i++) {
                        sb.append(out[i]+" ");
                    }
                    sb.append(out[n-1]);
                    sortResult.add(sb.toString());
                }
            }
            for (String list : sortResult) {
                System.out.println(list);
            }
        }
        in.close();
    }

    public static void fullArray(int[] a,int start,int n,ArrayList<int[]> result) {
        if(start == n) {
            return;
        }
        // 此时，将得到的一组排列存放在result中
        if(start == n-1) {
            int[] b = a.clone();
            result.add(b);
            return;
        }
        // 得到全排列
        for (int i = start; i < n; i++) {
            swap(a,start,i);
            fullArray(a, start+1, n, result);
            swap(a,start,i);
        }
    }

    public static void swap(int[] a,int i,int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // 判断是否排列是否合法，进行入栈出栈操作
    public static boolean isLegal(int[] in,int[] out,int n) {
        // 创建一个栈用来判断是否合法
        Stack<Integer> stack = new Stack<>();
        // i表示in的元素位置
        int i = 0;
        // j表示out的元素位置
        int j = 0;
        // 当in中有元素时都要进行判断
        while (i < n) {
            // 如果in和out相等，则直接跳过，不用进行入栈
            if(in[i] == out[j]) {
                i++;
                j++;
            }else { // 不等的时候首先判断栈中是否为空
                // 栈为空时，将in中元素进行入栈
                if(stack.isEmpty()) {
                    stack.push(in[i]);
                    i++;
                }else {
                    // 栈不为空时，查看栈顶元素，与out元素是否相等
                    int temp = stack.peek();
                    if(temp == out[j]) {
                        j++;
                        stack.pop();
                    }else if(i<n) {
                        // 不等的时候，in入栈
                        stack.push(in[i]);
                        i++;
                    }
                }
            }
        }
        // 当in中没有元素，且栈不为空时，此时栈中元素应该与out中的元素相等
        while(!stack.isEmpty() && j < n) {
            int temp = stack.pop();
            if(temp == out[j]) {
                j++;
            }else {
                return false;
            }
        }
        return true;
    }

}