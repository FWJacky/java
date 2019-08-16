package dailyTest;

import java.util.Scanner;

/**
 * @ClassName Test88
 * @Description TODO  回文串
 * @Author L
 * @Date 2019/8/15 13:42
 * @Version 1.0
 **/
public class Test88 {

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(isRight(str.toCharArray(),0,str.length()-1)?"YES":"NO");
        }
    }

    public static boolean isRight(char[] arr,int start,int end) {
        boolean flag = false;
        if (start >= end) {
            return true;
        }
        if(arr[start] == arr[end]) {
            return isRight(arr,start+1,end+1);
        }else {
            if(flag) {
                return false;
            }
            flag = true;
            return isRight(arr,start,end-1) || isRight(arr,start+1,end);
        }
    }

}
