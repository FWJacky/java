/**
 * @ClassName Test4
 * @Description TODO
 * @Author L
 * @Date 2019/4/12 22:35
 * @Version 1.0
 **/
public class Test4 {
    public static void leftRotateString(String str,int n) {
        StringBuffer sb = new StringBuffer();
        String str2=str.substring(0,n);
        String str3=str.substring(n);
        sb.append(str3).append(str2);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        String str = "abcdef";
        leftRotateString(str,2);
    }
}
