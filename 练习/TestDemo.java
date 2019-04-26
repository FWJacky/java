import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TestDemo
 * @Description TODO
 * @Author L
 * @Date 2019/4/20 13:34
 * @Version 1.0
 **/
public class TestDemo {
    public static int reverse(int x) {
        long res = 0L;
        if(x==0) {
            return 0;
        }
        //核心步骤
        while(x!=0) {
            res =res*10 + x%10;
            x = x/10;
        }
        if(res<-2147483648||res>2147483647) {
            return 0;
        }
        return (int)res;
    }
    public static void main(String[] args) {
        System.out.println(reverse(-1534236469));
        //123/10=12  12%10=2  12/10
//        int x = 1;
//        int a = x%10;
//        int b = x/10%10;
//        int c = x/10/10;
//        int y = a*100+10*b+c;
//        if(y<-2147483648||y>2147483647) {
//            System.out.println(0);
//        }else {
//            System.out.println(y);
//
//        }
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
    }
}
