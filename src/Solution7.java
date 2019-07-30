import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName Solution7
 * @Description TODO
 * @Author L
 * @Date 2019/7/25 20:36
 * @Version 1.0
 **/
public class Solution7 {
    public static void rotateString(char[] str, int offset) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        for (int i = str.length-offset; i < str.length; i++) {
            sb.append(str[i]);
        }
        for (int i = 0; i < str.length-offset; i++) {
            sb.append(str[i]);
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        char[] str = {'a','b','c','d','e','f','g'};
        int offset = 3;
        rotateString(str, offset);
    }
}
