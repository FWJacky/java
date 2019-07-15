package com.github.dailyTest;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @ClassName Test32
 * @Description TODO
 * @Author L
 * @Date 2019/7/15 11:57
 * @Version 1.0
 **/
public class Test32 {

    public static String AddLongInteger(String addend,String augend) {
        int len = addend.length() - augend.length();
        len = Math.abs(len);
        // 将字符串长的作为加数
        String strMaxs = addend.length()>augend.length()?addend:augend;
        // 将字符串短的作为被加数
        String strMins = addend.length()>augend.length()?augend:addend;
        // 将加数和被加数保存到数组中
        String[] strMax = strMaxs.split("");
        String[] strMin = strMins.split("");
        // 标记进位
        int carry = 0;
        for (int i = strMax.length-1; i >=0 ; i--) {
            int numMax = Integer.parseInt(strMax[i]);
            int numMin = 0;
            // 说明被加数还没有被遍历完，如果遍历完则默认为0
            if((i - len)>=0) {
                numMin = Integer.parseInt(strMin[i-len]);
            }
            // 将两数以及进制位相加
            int sum = numMax + numMin + carry;
            carry = 0;
            // 产生进位
            if(sum > 9) {
                carry = 1;
                sum -= 10;
            }
            // 将每一位运算后的结果保存到加数对应的位数
            strMax[i] = sum+"";
            // 如果遍历到最后一次循环还要进一位，则直接在加数前面加1
            if(i==0&&carry ==1) {
                strMax[0] = "1"+strMax[0];
            }
        }
        // 将得到的结果都保存到result中
        String result = "";
        for (String max : strMax) {
            result += max;
        }
       return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            String addend = in.nextLine();
            String augend = in.nextLine();
            System.out.println(AddLongInteger(addend,augend));
        }
        in.close();
    }
}
