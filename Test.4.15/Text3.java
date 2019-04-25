/**
 * @ClassName Text3
 * @Description TODO
 * @Author L
 * @Date 2019/4/18 19:58
 * @Version 1.0
 **/
public class Text3 {
    public static int fuction(int num) {
        //假设计算125    125%10=5  125/10=12 12%10   12/10=1  1%10=0
        int ret = 0;
        while(num !=0) {
            ret += (num%10)*(num%10);
            num = num / 10;
        }
        return ret;
    }
    public static boolean isHappy(int num) {
        if(num<=0) {
            return false;
        }
        while(num != 1) {
            num = fuction(num);
            if(num == 4) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isHappy(3));
        System.out.println(isHappy(7));
        System.out.println(isHappy(19));
    }
}
