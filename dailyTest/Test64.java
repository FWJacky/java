package dailyTest;

import java.util.Scanner;

/**
 * @ClassName Test64
 * @Description TODO  年会抽奖
 * @Author L
 * @Date 2019/8/2 11:23
 * @Version 1.0
 **/
/*
 *
 *@Param
 *@return
 * TODO 今年公司年会的奖品特别给力，但获奖的规则却很奇葩：
 *      1. 首先，所有人员都将一张写有自己名字的字条放在抽奖箱中
 *      2. 待所有字条加入完毕，每人从箱中去一个字条
 *      3. 如果抽到的字条上写的就是自己的名字，那么“恭喜你，中奖了!”
 *      现在告诉你参加晚会的人数，请你计算有多少概率会出现无人获奖？
 **/
public class Test64 {

    public static float molecule(int num) {
        if(num == 1) {
            return 0;
        }
        if(num == 2) {
            return 1;
        }
        return (num-1) * (molecule(num -1) + molecule(num-2));
    }

    public static float denominator(int num) {
        if(num == 1) {
            return 1;
        }
        return num*denominator(num-1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            float rs = (molecule(n) / denominator(n))*100;
            System.out.println(String.format("%.2f",rs)+"%");
        }
    }
}
