package dailyTest;


import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * @ClassName Test78
 * @Description TODO   字母统计   输入一行字符串，计算其中A-Z大写字母出现的次数
 * @Author L
 * @Date 2019/8/11 20:21
 * @Version 1.0
 **/
public class Test78 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            LinkedHashMap<Character,Integer> result = new LinkedHashMap<>();
            for (char i = 'A'; i <= 'Z'; i++) {
                result.put(i,0);
            }
            String string = scanner.nextLine();
            for (int i = 0;i < string.length();i++) {
                if(string.charAt(i)>='A'&&string.charAt(i)<='Z') {
                    result.put(string.charAt(i),result.get(string.charAt(i))+1);
                }
            }
            Set<Character> set = result.keySet();
            for (Character ch : set) {
                System.out.println(ch +" : "+ result.get(ch));
            }
        }
    }
}
