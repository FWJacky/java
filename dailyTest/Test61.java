package dailyTest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Test61
 * @Description TODO
 * @Author L
 * @Date 2019/7/31 11:38
 * @Version 1.0
 **/
public class Test61 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String ip = in.nextLine();
            String decimalIp = in.nextLine();
            System.out.println(ipToDecimalIp(ip));
            decimalIpToIp(decimalIp);
        }

    }

    public static void decimalIpToIp(String str) {
        long temp = Long.parseLong(str);
        String ip = Long.toBinaryString(temp);
        StringBuilder sb = new StringBuilder();
        if(ip.length() < 32) {
            for (int i = 0; i < 32-ip.length(); i++) {
                sb.append(0);
            }
            sb.append(ip);
        }else if(ip.length()==32) {
            sb.append(ip);
        }
        for (int i = 0; i < sb.length()-8; i+=8) {
            System.out.print(Integer.parseInt(sb.substring(i,i+8),2)+".");
        }
        System.out.println(Integer.parseInt(sb.substring(sb.length()-8,sb.length()),2));
    }

    public static long ipToDecimalIp(String ip) {
        String[] arr = ip.split("\\.");
        long n = Long.parseLong(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            n = n << 8;
            n += Long.parseLong(arr[i]);
        }
        return n;
    }
}
