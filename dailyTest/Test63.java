package dailyTest;

import java.util.Scanner;

/**
 * @ClassName Test63
 * @Description TODO  密码验证合格程序
 * @Author L
 * @Date 2019/8/1 22:33
 * @Version 1.0
 **/
public class Test63 {

    public static boolean checkLen(String password) {
        if (password.length() <= 8) {
            return false;
        }
        return true;
    }

    public static boolean checkSymbolType(String password) {
        int flag1 = 0;
        int flag2 = 0;
        int flag3 = 0;
        int flag4 = 0;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                flag1 = 1;
            } else if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z') {
                flag2 = 1;
            } else if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
                flag3 = 1;
            } else {
                flag4 = 1;
            }
        }
        int rs = flag1 + flag2 + flag3 + flag4;
        if (rs >= 3) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkRepeatedStr(String password) {
        for (int i = 0; i < password.length() - 2; i++) {
            StringBuilder sb = new StringBuilder(password);
            String str = sb.substring(i, i + 3);
            if(password.substring(i+1).contains(str)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String password = in.nextLine();
            if (checkLen(password) && checkSymbolType(password) && checkRepeatedStr(password)) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }
        in.close();
    }

}
