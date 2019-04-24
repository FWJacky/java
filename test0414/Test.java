import java.util.Arrays;

/**
 * @ClassName Test
 * @Description TODO
 * @Author L
 * @Date 2019/4/14 15:38
 * @Version 1.0
 **/
//interface IMessgae {
//    void getMessage();
//}
//class Message implements IMessgae {
//    public String toString() {
//        return "北京欢迎你";
//    }
//    @Override
//    public void getMessage() {
//        System.out.println("为你感到天地");
//    }
//}
public class Test {
    public static void main(String[] args) throws NumberFormatException {
        String str = String.valueOf(100);
        String str2 = String.valueOf(10.1f);
        String str3 = String.valueOf(10.10);
        String str4 = String.valueOf(false);
        String str5 = String.valueOf(12L);
        String str6 = String.valueOf('a');
        System.out.println(str);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
        System.out.println(str5);
        System.out.println(str6);
    }
}
