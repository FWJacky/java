package com.github.FWJacky;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

/**
 * @ClassName TestSingleton
 * @Description TODO
 * @Author L
 * @Date 2019/5/12 10:08
 * @Version 1.0
 **/
//饿汉式单例设计模式
//class Singleton {
//
//    public static final Singleton getInstance() {
//        return instance;
//    }
//
//    private static Singleton instance = new Singleton();
//
//    private Singleton(){
//
//    }
//
//    public void print() {
//        System.out.println("Hello JAVA");
//    }
//}

    class Singleton {

    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    private static Singleton instance;

        private Singleton(){}

        public void print() {
            System.out.println("Hello C++");
        }
}
public class TestSingleton {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton.hashCode());
        System.out.println(singleton1.hashCode());
//        singleton.print();
    }

}

