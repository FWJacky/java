package com.github.FWJacky;

import java.lang.reflect.Field;

/**
 * @ClassName TestGetField
 * @Description TODO
 * @Author L
 * @Date 2019/5/19 14:39
 * @Version 1.0
 **/

class Person1 {
    public String name;
    public int age;
}
class Stu extends Person1 {
    private String school;
    public int schoolId;
}
public class TestGetField {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        //先取得Stu类的Class对象
        Class<?> cls = Stu.class;
        //实例化本类对象
        Object obj = cls.newInstance();
        {
            //取得类中的全部属性
            //getFields() 取得父类和子类中的公开属性
            Field[] fields = cls.getFields();
            for (Field field : fields) {
                System.out.println(field);
            }
        }
        System.out.println("--------------------");
        {
            //取得类中指定名称属性
            Field field = cls.getField("schoolId");
            System.out.println(field);
        }
        System.out.println("--------------------");
        {
            //取得子类（当前类）中的全部属性
            //包括私有属性以及公开属性
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }
        }
        System.out.println("--------------------");
        {
            //取得子类（当前类）中的指定属性
            Field field = cls.getDeclaredField("school");
            //设置属性的内容
            //访问私有属性school时可以的，要利用setAccessible()方法
            //该方法默认时false，是禁止访问，当为true时是允许访问私有属性
            field.setAccessible(true);
            //设置属性内容的方法是：  属性的实例化对象.set(Object object,Object values)
            field.set(obj,"五道口大学");
            //取得属性内容的方法是：  属性的实例化对象.get(Object object)
            System.out.println(field.get(obj));
        }
        System.out.println("--------------------");
        {
            //动态封装属性
            //当属性本来就是非私有时，不能通过setAccessible()方法去修改它的访问权限即将其封装
            Field field = cls.getDeclaredField("schoolId");
            field.setAccessible(false);
            field.set(obj,01);
            System.out.println(field.get(obj));
        }
        System.out.println("--------------------");
        {
            //获得属性的参数类型——getType()
            //对于String类，getType()的是一个对象
            //对于int，输出的都是int
            Field field = cls.getDeclaredField("school");
            //类型 包名.类名—— class java.lang.String
            System.out.println(field.getType());
            //包名.类名——java.lang.String
            System.out.println(field.getType().getName());
            //类名——String
            System.out.println(field.getType().getSimpleName());
        }
    }
}
