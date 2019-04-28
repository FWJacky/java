package 日常练习;
import java.util.Arrays;

/**
 * @ClassName Test3
 * @Description TODO
 * @Author L
 * @Date 2019/4/12 20:34
 * @Version 1.0
 **/
public class Test3 {
    public static void swap(char[] ch, int left, int right) {
        while(left<right) {
            char tmp = ch[right];
            ch[right]=ch[left];
            ch[left]=tmp;
            left ++;
            right --;
        }
    }
    public static String reverseSentence(String str) {
        char[] ch = str.toCharArray();
        int left = 0;
        int right = ch.length-1;
        swap(ch,0,right);
        for (int i = 0; i < right; i++) {
            if (ch[i] == ' ') {
                swap(ch,left,i-1);
                left = i+1;
//                continue;
            }
        }
        swap(ch,left,right);
        return new String(ch);
    }
    public static void main(String[] args) {
        String str = "i am biter";
        System.out.println(reverseSentence(str));
    }
}
