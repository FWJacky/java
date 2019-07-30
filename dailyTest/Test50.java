package dailyTest;

import java.util.*;

/**
 * @ClassName Test50
 * @Description TODO
 * @Author L
 * @Date 2019/7/24 22:10
 * @Version 1.0
 **/
public class Test50 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String commodity = in.nextLine();
            String wants = in.nextLine();
            int count = 0;
            LinkedList<Character> list = new LinkedList<>();
            for (int i = 0; i < commodity.length(); i++) {
                list.add(commodity.charAt(i));
            }
            for (int i = 0; i < wants.length(); i++) {
                char ch = wants.charAt(i);
                for (int j = 0; j < list.size(); j++) {
                    if(list.get(j) == ch) {
                        list.remove(j);
                        count++;
                        break;
                    }
                }
            }
            if(count == wants.length()) {
                System.out.println("Yes" +" "+(commodity.length() - count));
            }else {
                System.out.println("No" + " " + (wants.length()-count));
            }
        }
    }
}
