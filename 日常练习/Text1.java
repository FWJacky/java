package 日常练习;
import java.util.Scanner;

/**
 * @ClassName Text1
 * @Description TODO
 * @Author L
 * @Date 2019/4/8 20:38
 * @Version 1.0
 **/


abstract class BankTemplate {
    public final void takeNumber() {
        System.out.println("取号");
    }
    public abstract void transact();
    public final void evaluate() {
        System.out.println("业务评价");
    }
    final void process() {
        takeNumber();
        transact();
        if(isEvaluate()){
        evaluate();
        }
    }
    public boolean isEvaluate() {
        return true;   //默认返回真
    }
}
class User1 extends BankTemplate {
    @Override
    public void transact() {
        System.out.println("取钱");
    }

    @Override
    public boolean isEvaluate() {
        return false;
    }


}
class User2 extends BankTemplate {
    @Override
    public void transact() {
        System.out.println("转账");
    }

    @Override
    public boolean isEvaluate() {
        return true;
    }
}
public class Text1 {
    public static void main(String[] args) {
        BankTemplate bankTemplate = new User1();
        BankTemplate bankTemplate1= new User2();
        bankTemplate.process();
        bankTemplate1.process();
//        User1 user1 = new User1();
//        User2 user2 = new User2();
//        user1.process();
//        user2.process();
    }
}
