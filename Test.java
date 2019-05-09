/**
 * @ClassName Test
 * @Description TODO
 * @Author L
 * @Date 2019/5/7 10:27
 * @Version 1.0
 **/
abstract class A{
    public A(){ //3.调⽤⽗类构造
        this.print() ; //4.调⽤被⼦类覆写的⽅法
    }
    public abstract void print() ;
}
class B extends A{
    private int num = 100 ;
    public B(int num) { //2.调⽤⼦类实例化对象
        super() ; //3.隐含⼀⾏语句，实际要先调⽤⽗类构造
        this.num = num ; //7.为类中属性初始化
    }
    public void print() { //5.此时⼦类对象的属性还没有被初始化
        System.out.println(this.num) ; //6.对应其数据类型的默认值
    }
}
public class Test{
    public static void main(String[] args) {
        new B(30) ; //1.实例化⼦类对象
    }

}
