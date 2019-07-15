package com.github.dailyTest;

/**
 * @ClassName Test33
 * @Description TODO
 * @Author L
 * @Date 2019/7/15 14:22
 * @Version 1.0
 **/
public class Test33 {

    public static String addLongInteger(String addend,String augent) {
        // 计算出加数与被加数之间的位数差
        // 位数长度可能为负数，取绝对值
        int len = Math.abs(addend.length()- augent.length());
        // 将位数长的，即字符串长度长的作为加数，字符串短的作为被加数
        String strAddends = addend.length()>augent.length()?addend:augent;
        String strAugents = addend.length()> augent.length()?augent:addend;
        // 将字符串保存到数组中
        String[] strAddend = strAddends.split("");
        String[] strAugent = strAugents.split("");
        // 创建一个变量用来标记进制位
        int carry = 0;
        // 从加数最后一位进行运算，倒序遍历
        for (int i = strAddend.length-1; i >= 0 ; i--) {
            // 加数
            int numAddend = Integer.parseInt(strAddend[i]);
            // 被加数，如果i-len<0时，说明此时加数有位数，但是被加数没有位数了,此时被加数的位数默认为0
            // 例如：
            // 加数：999
            // 被加数： 1
            // len = 3-1 = 2
            // 第一次循环时，i-len = 2-2 = 0 ，说明此时被加数有一位为1
            // 第二次循环时，i-len = 1-2 = -1，说明此时加数为十位数，但是被加数十位数没有数了，则默认为0
            int numAugent = 0;
            if((i-len)>=0) {
                // 如果i-len>=0，此时加数相对于的被加数的位数就为strAugent(i-len)
                numAugent = Integer.parseInt(strAugent[i-len]);
            }
            int sum = numAddend + numAugent + carry;
            // 每一次循环运算时，都需要将进制位置为0
            carry = 0;
            if(sum > 9) {
                carry =1;
                sum -= 10;
            }
            strAddend[i] = sum+"";
            // 当遍历完加数时，此时进制位为1；则在运算后得到的加数前加上1
            if(i==0 && carry == 1) {
                strAddend[0] = "1" + strAddend[0];
            }
        }
        String result = "";
        for (String max : strAddend) {
            result += max;
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
