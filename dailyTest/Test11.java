/**
 * @ClassName Test11
 * @Description TODO
 * @Author L
 * @Date 2019/7/4 23:30
 * @Version 1.0
 **/
public class Test11 {
    String str = new String("good");
    char[] ch = {'a','b','c'};

    public static void main(String[] args) {
        Test11 t = new Test11();
        t.opera(t.str, t.ch);
        System.out.print(t.str+" and ");
        System.out.print(t.ch);
    }

    public void opera(String str,char[] ch) {
        str = "test ok";
        ch[0] = 'g';
    }
}
