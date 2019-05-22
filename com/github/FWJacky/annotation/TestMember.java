package com.github.FWJacky.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import com.github.FWJacky.Mymath;
import com.github.FWJacky.annotation.Member;

/**
 * @ClassName TestMember
 * @Description TODO
 * @Author L
 * @Date 2019/5/22 21:06
 * @Version 1.0
 **/
public class TestMember {

    public static void code1() {
        Annotation[] ant = Member.class.getAnnotations();
        for (Annotation annotation : ant) {
            System.out.println(annotation);
        }
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Class<?> cls = Member.class;
        MyAnnotation myAnnotation = cls.getDeclaredAnnotation(MyAnnotation.class);
        System.out.println(myAnnotation);
        int age = myAnnotation.age();
        System.out.println(age);
        String name = myAnnotation.name();
        System.out.println(name);
        System.out.println(name + " " + age);

//        Method method = Member.class.getDeclaredMethod("toString");
//        Annotation[] ant = method.getAnnotations();
//        for (Annotation annotation : ant) {
//            System.out.println(annotation);
//        }
    }
}
