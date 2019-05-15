package com.bit.TestReflex;

import com.sun.org.apache.bcel.internal.generic.IfInstruction;

/**
 * @ClassName FactoryModel
 * @Description TODO
 * @Author L
 * @Date 2019/5/15 20:55
 * @Version 1.0
 **/
interface IFruit {
    void eat();
}
class Apple implements IFruit {

    @Override
    public void eat() {
        System.out.println("吃苹果");
    }
}
class FruitFactory {
    private FruitFactory() {}
    public static IFruit getInstance(String className) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException {
        IFruit fruit =(IFruit)Class.forName(className).newInstance();
        return fruit;
    }
}
class Orange implements IFruit {

    @Override
    public void eat() {
        System.out.println("吃橘子");
    }
}
public class FactoryModel {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        IFruit fruit = FruitFactory.getInstance("com.bit.TestReflex.Orange");
        fruit.eat();
    }
}
