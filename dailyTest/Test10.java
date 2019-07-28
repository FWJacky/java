import java.util.Scanner;

/**
 * @ClassName Test10
 * @Description TODO
 * @Author L
 * @Date 2019/7/4 12:31
 * @Version 1.0
 **/
public class Test10 {

    public static String reString(String str,String target) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length(); i++) {
            for (int j = 0; j < target.length(); j++) {
                if(sb.charAt(i)==target.charAt(j)){
                    sb.deleteCharAt(i);
                }
            }
        }
        return String.valueOf(sb);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            String str = in.nextLine();
            String target = in.nextLine();
            String result = reString(str, target);
            System.out.println(result);
        }
    }
}
