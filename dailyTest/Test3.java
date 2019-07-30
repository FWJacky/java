/**
 * @ClassName Test3
 * @Description TODO
 * @Author L
 * @Date 2019/7/1 22:49
 * @Version 1.0
 **/

abstract class A {
    public A(){
        this.print();
    }

    public abstract void print();

}

public class Test3 extends A{

    private int num = 100;

    public Test3(int num) {
        super();
        this.num = num;
    }

    @Override
    public void print() {
        System.out.println(this.num);
    }


    public static void main(String[] args) {
        new Test3(30);
    }
}
