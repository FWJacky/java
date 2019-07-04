import java.util.Scanner;

/**
 * @ClassName Test
 * @Description TODO
 * @Author L
 * @Date 2019/6/30 22:03
 * @Version 1.0
 **/
//public class Test {
//
//    public static void main(String[] args) {
//        String a = null;
//        String b = null;
//        int len = -1;
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextLine()) {
//            int count = 0;
//            a = scanner.nextLine();
//            b = scanner.nextLine();
//            if (a.length() == 0 || b.length() == 0) {
//                System.out.println(count++);
//            } else {
//                if (a.length() >= b.length()) {
//                    len = a.length();
//                } else {
//                    String tmp = b;
//                    b = a;
//                    a = tmp;
//                    len = a.length();
//                }
//                for (int i = 0; i <= len; i++) {
//                    StringBuilder A = new StringBuilder(a);
//                    String rs = String.valueOf(A.insert(i, b));
//                    char[] newStr = rs.toCharArray();
//                    int low = 0;
//                    int hight = newStr.length - 1;
//                    while (low < hight) {
//                        char left = newStr[low];
//                        char right = newStr[hight];
//                        if (left == right) {
//                            low++;
//                            hight--;
//                        } else {
//                            break;
//                        }
//                    }
//                    if (low == hight || low > hight) {
//                        count++;
//                    }
//                }
//            }
//            System.out.println(count);
//        }
//    }
//}

public class Test {
    public static int insert(String src,String dec){
        int count = 0;
//        StringBuffer stringBuffer = new StringBuffer(src);
        for (int i = 0;i<src.length();i++) {
//            StringBuffer stringBuffer1 = stringBuffer.insert(i, dec);
            StringBuilder stringBuilder = new StringBuilder(src);
            StringBuilder str = stringBuilder.insert(i,dec);
            String str1 = str.toString();
            char[] str2 = str1.toCharArray();
            int s = str2.length - 1;
            int flag = 0;
            for (int j = 0; j <= s; j++, s--) {
                if (str2[j] != str2[s]) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                count += 1;
            }
        }
        return  count;
    }
    public static void main(String[] args) {
         int rs =Test.insert("aba","b");
        System.out.println(rs);
    }
}