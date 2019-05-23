package com.github.FWJacky.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @ClassName Factory
 * @Description TODO
 * @Author L
 * @Date 2019/5/23 16:35
 * @Version 1.0
 **/

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotations {
    public Class<?> target();
}

interface IFruit {
    void eat();
}

class Apple implements IFruit {

    @Override
    public void eat() {
        System.out.println("吃苹果");
    }
}

@MyAnnotations(target = Apple.class)
class Factory {
    public static <T> T getInstance() throws IllegalAccessException, InstantiationException {
        MyAnnotations mt = Factory.class.getAnnotation(MyAnnotations.class);
        System.out.println(mt);
        return (T) mt.target().newInstance();
    }
}
public class TestAnnotation {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        IFruit fruit = Factory.getInstance();
        System.out.println(fruit);
        fruit.eat();
    }
}
