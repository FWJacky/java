package com.github.FWJacky;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName TestMethod
 * @Description TODO
 * @Author L
 * @Date 2019/5/19 14:17
 * @Version 1.0
 **/

class Student {

    private String name;
    private int age;
    public Student(){}
    public Student(String name,int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
public class TestMethod {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        //首先获得Student的Class对象
        Class<?> cls = Student.class;
        //获得全部普通方法
        //getMethods()会获得当前类以及其父类的普通方法
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        //getDeclaredMethods()只会获得当前类的全部普通方法
        Method[] methods1  = cls.getDeclaredMethods();
        for (Method method : methods1) {
            System.out.println(method);
        }
        //获得指定普通方法
        Method setMethod = cls.getMethod("setName", String.class);
        System.out.println(setMethod);
        Method getMethod = cls.getMethod("getName");
        System.out.println(getMethod);
        //调用普通方法
        Object obj = cls.newInstance();
        setMethod.invoke(obj,"张三");
        System.out.println(getMethod.invoke(obj));
    }
}
