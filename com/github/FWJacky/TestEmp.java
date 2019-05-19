package com.github.FWJacky;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName TestEmp
 * @Description TODO
 * @Author L
 * @Date 2019/5/19 15:12
 * @Version 1.0
 **/

class Emp {
    private String ename;
    private String job;

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
class EmpAction {

}
public class TestEmp {

    public static void arrtibuteSetValue(Object object,String name,String values) throws NoSuchFieldException, IllegalAccessException {
        //先取得需要赋值的类的Class对象
        Class<?> cls = object.getClass();
        //取得指定的属性
        Field arrtubuteField = cls.getDeclaredField(name);
        //属性都是私有的，要将其解封
        arrtubuteField.setAccessible(true);
        arrtubuteField.set(object,values);
    }

    public static void methodSetValue(Object object,String name,String value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> cls = object.getClass();
        String setMethodName = "set" + name.substring(0,1).toUpperCase() + (name.length() == 1
        ?"":name.substring(1));
        Method setMethod = cls.getDeclaredMethod(setMethodName,value.getClass());
        setMethod.invoke(object,value);
    }
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        {
//            Emp emp = new Emp();
//            emp.setEname("老王");
//            emp.setJob("清洁工");
//            System.out.println(emp);
//        }
        System.out.println("------------------");
        {
            Emp emp = new Emp();
            String str = "ename:Jack|job:Java Soft Engineer";
            //ename: Jack
            // => Field ename ; getEname ; getXxx setXxx
            //job : Java Soft Engineer
            // => Field job ; getJob ; getXxx setXxx
            //通过反射进行Emp对象的赋值
            //1. 通过属性赋值
            //2. 通过setter赋值

            //第一步：解析字符串
            //先将字符串按|拆解
            String[] arrtibuteNameAndValues = str.split("\\|");
            //再将拆解后的字符串按照:拆解
            for (String nameAndValues : arrtibuteNameAndValues) {
                String[] nameAndValue = nameAndValues.split(":");
                String name = nameAndValue[0];
                String value = nameAndValue[1];
                //赋值操作
                //1. 通过属性赋值
                arrtibuteSetValue(emp,name,value);
                //2. 通过方法赋值
                methodSetValue(emp,name,value);
            }
            System.out.println(emp);
        }

    }
}
