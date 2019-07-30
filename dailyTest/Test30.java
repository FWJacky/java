package com.github.dailyTest;

import java.util.Arrays;

/**
 * @ClassName Test30
 * @Description TODO
 * @Author L
 * @Date 2019/7/13 12:59
 * @Version 1.0
 **/
public class Test30 {
    public String[] getGray(int n) {
        // write code here
        String[] grayCode = new String[(int) Math.pow(2,n)];
        //产生"0","1"字符串
        if(n==1) {
            grayCode[0] = "0";
            grayCode[1] = "1";
            return grayCode;
        }
        //每一个字符串都加上"0","1"
        String[] last = getGray(n-1);
        for (int i = 0; i < last.length; i++) {
            grayCode[i] = "0" + last[i];
            grayCode[grayCode.length-1-i] = 1 + last[i];
        }
        return grayCode;
    }

    public static String[] getGrayCode(int n) {
        //首先要产生n位元的格雷码，那么格雷数的个数为2^n
        // grayCode数组用来存放所需要的格雷数
        String[] grayCode = new String[(int) Math.pow(2, n)];
        // 首先当n==1时，格雷数为"0","1"
        // 先给出"0","1"字符串，然后每次字符串都加上0和1，一次只能加一个
        if(n==1) {
            grayCode[0] = "0";
            grayCode[1] = "1";
            return grayCode;
        }
        //当n>1时，格雷数为第一个与最后一个的格雷码对称（除掉第一位格雷码）
        // 例如：
        // 000
        // 001
        // 011
        // 010
        // 110
        // 111
        // 101
        // 100
        //递归，直到得到n==1时的格雷数集合
        String[] last = getGrayCode(n-1);
        // 当n==2时，此时last.length == 2
        for (int i = 0; i < last.length; i++) {
            grayCode[i] = "0" + last[i];
            //对称性，相对应的格雷码只是第一位不同，其余相同
            grayCode[grayCode.length-1-i] = "1" + last[i];
        }
        return grayCode;
    }

    public static void main(String[] args) {
//        Test30 ts = new Test30();
        System.out.println(Arrays.toString(getGrayCode(3)));
    }
}
