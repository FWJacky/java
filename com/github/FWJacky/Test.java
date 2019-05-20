package com.github.FWJacky;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @ClassName Test
 * @Description TODO
 * @Author L
 * @Date 2019/5/20 21:40
 * @Version 1.0
 **/

class A {
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
public class Test {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        Class<?> cls = A.class;
//        A a = new A();
//        Field[] fields = cls.getDeclaredFields();
//        for (int i = 0; i < fields.length; i++) {
//            System.out.println(fields[i].getName());
//            String setNameMethod = "set" + fields[i].getName().substring(0,1).toUpperCase() +
//                    (fields[i].getName().length() == 1 ? "" : fields[i].getName().substring(1));
//            System.out.println(setNameMethod);
////            Method method = cls.getDeclaredMethod(setNameMethod,fields[i].getType());
////            method.invoke(a,"name");
//        }
        System.out.println(String.class);

    }
}
