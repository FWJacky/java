package dailyTest;

import java.util.Scanner;

/**
 * @ClassName Test92
 * @Description TODO  坐标移动
 * @Author L
 * @Date 2019/8/17 14:46
 * @Version 1.0
 **/
public class Test92 {

    static int x = 0;
    static int y = 0;

    public static boolean isLegal(String string) {
        if (!(string.startsWith("A") || string.startsWith("D") || string.startsWith("S") || string.startsWith("W"))) {
            return false;
        }
        String str = string.substring(1);
        if (str.length() > 2) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] strings = sc.nextLine().split(";");
            for (String str : strings) {
                if (isLegal(str)) {
                    move(str);
                }
            }
            System.out.println(x + "," + y);
            x = 0;
            y = 0;
        }
    }

    public static void move(String string) {
        String direction = string.substring(0, 1);
        int distance = Integer.parseInt(string.substring(1));
        switch (direction) {
            case "A":
                x = x - distance;
                break;
            case "D":
                x = x + distance;
                break;
            case "S":
                y = y - distance;
                break;
            case "W":
                y = y + distance;
                break;
            default:
                break;
        }
    }
}
