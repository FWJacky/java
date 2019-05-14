package com.bit.FunctionQuote;

/**
 * @ClassName TestFucQuo
 * @Description TODO
 * @Author L
 * @Date 2019/5/14 22:46
 * @Version 1.0
 **/

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class TestFucQuo {
//    public static void switchpara2() {
//        IUtil2<String> iUtil2 = "hello"::toUpperCase;
//        System.out.println(iUtil2.switchPara());
//    }
//
//    public static void switchPara() {
//        IUtil<Integer, String> iUtil = String::valueOf;
//        String str = iUtil.switchPara(10);
//        System.out.println(str.length());
//        System.out.println(iUtil.switchPara(10));
//    }
//
//    public static void person() {
//        IUtil4<Person, String, Integer> iUtil4 = Person::new;
//        System.out.println(iUtil4.createPerson("Java", 20));
//    }
//
//    public static void compareTo() {
//        IUtil3<Integer, String> iUtil3 = String::compareTo;
//        System.out.println(iUtil3.compare("a", "b"));
    public static void main(String[] args) {
        System.out.println("hehe");
    }

}

    //函数接口——引用构造方法：    类名称::new
    @FunctionalInterface
    interface IUtil4<R,PN,PA> {
        R createPerson(PN p1, PA p2);
    }

    //函数接口——引用某个特定类的方法：  类名称::普通方法
    @FunctionalInterface
    interface IUtil3<R,P> {
        R compare(P p1, P p2);
    }

    //函数接口——引用对象方法：  实例化对象::普通方法
    @FunctionalInterface
    interface IUtil2<P> {
        P switchPara();
    }

    //函数接口——引用静态方法：  类名称::静态方法名称
    @FunctionalInterface
    interface  IUtil<P,R> {
       R switchPara(P p);
    }