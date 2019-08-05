package dailyTest;

import java.util.Scanner;

/**
 * @ClassName Test68
 * @Description TODO   说反话
 * @Author L
 * @Date 2019/8/5 11:42
 * @Version 1.0
 **/

/*
 * 给定一句英语，要求你编写程序，将句中所有单词的顺序颠倒输出
 * 例如：Hello World Here I Come
 * 输出：Come I Here World Hello
 *
 **/
public class Test68 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String str = in.nextLine();
            String[] words = str.split(" ");
            for (int i = words.length-1; i > 0 ; i--) {
                System.out.print(words[i]+" ");
            }
            System.out.print(words[0]);
            System.out.println();
        }
        in.close();
    }
}
