package com.github.FWJacky.classLoader;

public class ClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        Class<?> cls = Member.class;
//        System.out.println(cls.getClassLoader());
//        System.out.println(cls.getClassLoader().getParent());
//        System.out.println(cls.getClassLoader().getParent().getParent());
//        System.out.println(Class.forName("com.github.FWJacky.Member").getClassLoader().
//                loadClass("com.github.FWJacky.Member").newInstance());
        Class<?> cls = Member.class;
        System.out.println(cls.getClassLoader());
        //loadClass(String name)是加载name类，产生name的Class对象——class com.github.FWJacky.Member
        System.out.println(cls.getClassLoader().loadClass("com.github.FWJacky.Member"));
        //newInstance() 是通过反射实例化对象——Member
        System.out.println(cls.getClassLoader().loadClass("com.github.FWJacky.Member").newInstance());
        //Member
        System.out.println(cls.newInstance());
        //false
        System.out.println(cls.newInstance().equals(cls.getClassLoader().loadClass("com.github.FWJacky.Member").newInstance()));
    }
}
