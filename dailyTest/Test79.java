package dailyTest;

import java.util.Scanner;

/**
 * @ClassName Test79
 * @Description TODO  进制转换  写一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串
 * @Author L
 * @Date 2019/8/11 20:29
 * @Version 1.0
 **/
public class Test79 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String hexadecimalStr = scanner.nextLine();
            int rs = 0;
            int len = hexadecimalStr.length()-1;
            for (int i = hexadecimalStr.length()-1; i >= 0 ; i--) {
                if (hexadecimalStr.charAt(i) >= 'A'&&hexadecimalStr.charAt(i) <='F') {
                    rs += getNum(hexadecimalStr.charAt(i))*Math.pow(16,len-i);
                }else if(hexadecimalStr.charAt(i) >= '0'&&hexadecimalStr.charAt(i) <='9'){
                    rs += Integer.parseInt(String.valueOf(hexadecimalStr.charAt(i)))*Math.pow(16,len-i);
                }
            }
            System.out.println(rs);
        }
    }

    public static int getNum(char ch) {
        switch (ch) {
            case 'A':
                return 10;
            case 'B':
                return 11;
            case 'C':
                return 12;
            case 'D':
                return 13;
            case 'E':
                return 14;
            case 'F':
                return 15;
            default:
                break;
        }
        return -1;
    }

}
