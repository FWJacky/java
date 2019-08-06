package dailyTest;

import java.util.Collections;

/**
 * @ClassName Test71
 * @Description TODO  2的个数
 * @Author L
 * @Date 2019/8/6 11:14
 * @Version 1.0
 **/
/*
 *  编写一个方法，输出0到n（包括n）中数字2出现了几次
 *  思路：分别计算个位、十位、百位、千位出现2的个数，然后找到规律
 *
 **/
public class Test71 {
    public  static int countNumberOf2s(int n) {
        // write code here
        // 用于计数
        int count = 0;
        // 用于移位
        int flag = 1;
        int high = 0;
        int low = 0;
        int cur = 0;
        while (n / flag != 0) {
            // 从个位开始
            cur = (n / flag) % 10;
            low = n - (n / flag) * flag;
            high = n / (flag * 10);
            // 用来统计高位
            if (cur < 2) {
                count += high * flag;
            }
            if(cur == 2) {
                count += high*flag + low +1;
            }
            if(cur >2) {
                count += (high+1)*flag;
            }
            flag *= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        int res = countNumberOf2s(2);
        System.out.println(res);
    }
}
