package com.bit.TestReflex;

import java.sql.DatabaseMetaData;
import java.util.Date;

/**
 * @ClassName TestReflex
 * @Description TODO
 * @Author L
 * @Date 2019/5/15 19:10
 * @Version 1.0
 **/
public class TestReflex {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Date date = new Date();
        Class<?> class1 = Class.forName("java.util.Date");
        Object obj = class1.newInstance(); //通过反射实例化对象，利用newInstance()方法
        System.out.println(date.getClass());
        System.out.println(Date.class);
        System.out.println(date.getClass() == Date.class);//true
        System.out.println(date);
        Class aClass = Date.class;
        System.out.println(class1.getName());
        System.out.println(aClass == class1);
        System.out.println(class1);
        //通过构造方法实例化的对象 和 通过反射实例化的对象 内容相等
        System.out.println(obj);
        System.out.println(date);
        System.out.println(obj.equals(date));//true
        System.out.println(Date.class);
    }
}
