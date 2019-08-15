package dailyTest;

import java.util.Arrays;

/**
 * @ClassName Test86
 * @Description TODO  空格交换
 * @Author L
 * @Date 2019/8/15 10:21
 * @Version 1.0
 **/
public class Test86 {

    public static void main(String[] args) {
        String string = "My best friend ";
        StringBuilder sb = new StringBuilder();
        String[] str = string.split(" ");
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]).append("%20");
        }
        String str2 = string.replaceAll(" ","%20");
        System.out.println(str2);
    }

}
