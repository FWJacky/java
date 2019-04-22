import javax.swing.*;
import java.util.Scanner;

/**
 * @ClassName Test
 * @Description TODO
 * @Author L
 * @Date 2019/4/10 19:52
 * @Version 1.0
 **/
class MessageImpl extends News implements IMessage{
    public void print() {
        System.out.println("I am a biter");
    }
    public void getNews() {
        System.out.println("I am News");
    }
}

//abstract class Person {
//    private String name;
//
//    public String getName() {
//        return this.name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public abstract void getPersonInfo();
//
//    public static Person getInstance() {
//        class Student extends Person {
//            public void getPersonInfo() {
//                System.out.println("I am a student");
//            }
//        }
//        return new Student();
//    }
//}
//abstract class A {
//    public A () {
//        this.print();
//    }
//    public abstract void print();
//}
//class B extends A {
//    private int num = 10;
//    public B(int num) {
////        super();
//        this.num = num;
//    }
//    public void print() {
//        System.out.println(this.num);
//    }
//}

abstract class Drink {
    void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if(isAddCondiments()) {
            addCondiments();
        }
    }
    public abstract void addCondiments();
    public abstract void brew();
    public final void boilWater() {
        System.out.println("将水煮沸");
    }
    public final void pourInCup() {
        System.out.println("将饮料倒入杯中");
    }
    public boolean isAddCondiments() {
        return true;
    }

}
class Coffe extends Drink {
    @Override
    public void addCondiments() {
        System.out.println("加糖和牛奶");
    }

    @Override
    public void brew() {
        System.out.println("用沸水冲泡Coffee");
    }

    @Override
    public boolean isAddCondiments() {
        System.out.println("请问你要加入调料吗?加 or 不加");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if(str.equals("加")) {
            return true;
        }
        return false;
    }
}
class Tea extends Drink {
    @Override
    public void addCondiments() {
        System.out.println("加柠檬");
    }

    @Override
    public void brew() {
        System.out.println("用沸水浸泡茶叶");
    }

    @Override
    public boolean isAddCondiments() {
        System.out.println("请问你要加入调料吗?加 or 不加");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str.equals("加")) {
            return true;
        }
        return false;
    }
}
public  class Test {
    public static void main(String[] args) {
        Drink drink = new Coffe();
        drink.prepareRecipe();
        System.out.println("============");
        Drink drink1 = new Tea();
        drink1.prepareRecipe();

//        new B(30);
//        Person per = Person.getInstance();
//        per.getPersonInfo();
    }
//        IMessage m = new MessageImpl();
//        m.print();
////        News news = (News) m;
//        News news = new MessageImpl();
//        news.getNews();

}