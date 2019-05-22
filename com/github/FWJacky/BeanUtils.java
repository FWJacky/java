package com.github.FWJacky;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @ClassName BeanUtils
 * @Description TODO
 * @Author L
 * @Date 2019/5/20 21:00
 * @Version 1.0
 **/

class Source {
    private String name;
    private String address;
    private Integer age;
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Source{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}

class Target {
    private String name;
    private String address;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Target{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
public class BeanUtils {

    //通过属性进行拷贝
    public static void copy(Object source, Object target) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //TODO
        Class<?> aClassSource = source.getClass();
        Class<?> aClassTarget = target.getClass();
        Field[] targetField = aClassTarget.getDeclaredFields();
        Field[] sourceField = aClassSource.getDeclaredFields();
        for (int i = 0; i < sourceField.length; i++) {
            for (int j = 0; j < targetField.length; j++) {
                targetField[j].setAccessible(true);
                sourceField[i].setAccessible(true);
                if(sourceField[i].getName().equals(targetField[j].getName()) &&
                        sourceField[i].getType().equals(targetField[j].getType())) {
                   targetField[j].set(target,sourceField[i].get(source));
                }
                break;
            }
        }
    }

    //通过方法进行拷贝
    public static void methodCopy(Object source,Object target) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> sourceClass = source.getClass();
        Class<?> targetClass = target.getClass();
        Field[] sourceField = sourceClass.getDeclaredFields();
        Field[] targetField = targetClass.getDeclaredFields();
        for (int i = 0; i < sourceField.length; i++) {
            for (int j = 0; j < targetField.length; j++) {
                String setNameMethod = "set" + targetField[j].getName().substring(0,1).toUpperCase()
                        + (targetField[j].getName().length() == 1 ? "" : targetField[j].getName().substring(1));
                String getNameMethod = "get" +  sourceField[i].getName().substring(0,1).toUpperCase()
                        + (sourceField[i].getName().length() == 1 ? "" : sourceField[i].getName().substring(1));
                if(targetField[j].getType().equals(sourceField[i].getType()) &&
                        targetField[j].getName().equals(sourceField[i].getName())) {
                    Method setName = targetClass.getDeclaredMethod(setNameMethod,targetField[j].getType());
                    Method getName = sourceClass.getDeclaredMethod(getNameMethod);
                    //先将source对象中属性的值保存起来
//                    String value = (String) getName.invoke(source);
//                    setName.invoke(target,value);
                    setName.invoke(target,(String) getName.invoke(source));
                }
            }
        }
    }


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Source source = new Source();
        Target target = new Target();
        Date date = new Date(2001-5-20);
        source.setName("张三");
        source.setAddress("中国");
        source.setAge(18);
        source.setBirthday(date);
//        target.setAddress("美国");
//        target.setEmail("123456@163.com");
//        target.setName("李四");
        //通过属性进行拷贝
//        copy(source,target);
//        System.out.println(target);
        //通过方法进行拷贝
        methodCopy(source,target);
        System.out.println(target);
    }
}
