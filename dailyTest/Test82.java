package dailyTest;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Test82
 * @Description TODO
 * @Author L
 * @Date 2019/8/13 21:30
 * @Version 1.0
 **/
public class Test82 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i)>='0'&&str.charAt(i)<='9') {
                    sb.append(str.charAt(i));
                }else {
                    list.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
            if(sb.length()!=0) {
                list.add(sb.toString());
            }
            int max = 0;
            String res = "";
            for(String string : list) {
                if(string.length()>=max) {
                    max = string.length();
                    res = string;
                }
            }
            System.out.println(res);
        }
    }
}
