/**
 * @ClassName HelloB
 * @Description TODO
 * @Author L
 * @Date 2019/7/1 15:51
 * @Version 1.0
 **/
class HelloA {
    //构造⽅法
    public HelloA(){
        System.out.println("Hello A!⽗类构造⽅法");
    }
    //⾮静态代码块
    {
        System.out.println("i'm A class.⽗类⾮静态代码块");
    }
    //静态代码块
    static{
        System.out.println("static A ⽗类静态代码块");
    }
}
public class HelloB extends HelloA {
    //构造⽅法
    public HelloB(){
        System.out.println("Hello B! 构造⽅法");
    }
    //⾮静态代码块
    {
        System.out.println("i'm B class.⾮静态代码块");
    }
    //静态代码块
    static{
        System.out.println("static B 静态代码块");
    }
    public static void main(String[] args) {
        System.out.println("---start---");
        new HelloB();
        new HelloB();
        System.out.println("---end---");
    }
}

