package com.github.FWJacky;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName TestEmp1
 * @Description TODO
 * @Author L
 * @Date 2019/5/20 20:20
 * @Version 1.0
 **/

class Emp1 {
    private String ename;
    private String job;

    public String getEname() {
        return ename;
    }

    public void setEname(String name) {
        this.ename = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Emp1{" +
                "name='" + ename + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
public class TestEmp1 {
    public static void setNameMethod(Object object,String name,String value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> cls = object.getClass();
        String setNameMethod = "set" + name.substring(0,1).toUpperCase() + (name.length() == 1 ? "" : name.substring(1));
        String getNameMethod = "get" + name.substring(0,1).toUpperCase() + (name.length() == 1 ? "" : name.substring(1));
        //得到setName方法
        Method setName = cls.getDeclaredMethod(setNameMethod,String.class);
        Method getName = cls.getDeclaredMethod(getNameMethod);
        setName.invoke(object,value);
        System.out.println(getName.invoke(object));
    }

    public static void fieldMethod(Object object,String name,String value) throws NoSuchFieldException, IllegalAccessException {
        Class<?> cls = object.getClass();
        Field field = cls.getDeclaredField(name);
        field.setAccessible(true);
        field.set(object,value);
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Emp1 emp1 = new Emp1();
        //解析字符串
        String text = "ename:Jack|job:Java Soft Engineer";
        String[] str = text.split("\\|");
        for (String attributeNameAndValue : str) {
            String[] attributeNameAndValues = attributeNameAndValue.split(":");
            String name = attributeNameAndValues[0];
            String value = attributeNameAndValues[1];
            //1. 通过setter方法赋值
            setNameMethod(emp1,name,value);
            //通过属性赋值
//            fieldMethod(emp1,name,value);
        }
        System.out.println(emp1);



    }
}
