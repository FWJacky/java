package com.github.FWJacky;

import javax.jnlp.IntegrationService;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName TestGetConstructor
 * @Description TODO
 * @Author L
 * @Date 2019/5/18 14:05
 * @Version 1.0
 **/
class Person {
    private int age;
    private String name;
    public Person(int age,String name) {
        this.age = age;
        this.name = name;
    }
    public Person(int age) {
        this.age = age;
    }
    public Person() {}

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
public class TestGetConstructor {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //首先得到Person的Class对象
        Class<?> cls = Person.class;
        //调用Person的全部构造方法
        //getConstructors()得到的是一个对象数组
        //如果使用getName()方法，只会返回包名.类名
        //如果不适用getName()方法，则利用Constructor类中的toString()方法取得构造方法的完整信息：
        //即方法权限修饰符、包名、类名、参数列表
//        Constructor<?>[] constructors = cls.getConstructors();
//        for (Constructor<?> constructor : constructors) {
//            System.out.println(constructor.getName());
//            System.out.println(constructor);
//        }
        //调用指定参数类型的构造方法
        Constructor<?> constructor = cls.getConstructor(int.class,String.class);
        Person p = (Person) constructor.newInstance(20,"张三");
        System.out.println(p.getClass().getName());
    }
}
