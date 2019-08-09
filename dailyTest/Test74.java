package dailyTest;

import java.util.*;

/**
 * @ClassName Test74
 * @Description TODO Broken Keyboard
 * @Author L
 * @Date 2019/8/8 23:16
 * @Version 1.0
 **/
public class Test74 {

    public static void main(String[] args) {
        LinkedHashSet<String> list = new LinkedHashSet<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String originStr = scanner.nextLine().toUpperCase();
            String outputStr = scanner.nextLine().toUpperCase();
            int index = 0;
            int i = 0;
            for (i = 0; i < originStr.length(); i++) {
                if (index < outputStr.length()) {
                    if (originStr.charAt(i) == outputStr.charAt(index)) {
                        index++;
                    } else if (originStr.charAt(i) != outputStr.charAt(index) && originStr.charAt(i) != '_') {
                        list.add(String.valueOf(originStr.charAt(i)));
                    }
                } else {
                    list.add(String.valueOf(originStr.charAt(i)));
                }
            }
            for (String str : list) {
                System.out.print(str);
            }
        }
    }
}
