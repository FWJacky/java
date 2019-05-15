package com.bit.Testenum;

/**
 * @ClassName EnumSex
 * @Description TODO
 * @Author L
 * @Date 2019/5/15 18:45
 * @Version 1.0
 **/
enum Sex {
    MALE("男"),FEMALE("女");

    private String title;
    private Sex(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
class Person {
    private String name;
    private int age;
    private Sex sex;
    public Person(String name,int age,Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
enum Sex1 {
    MALE,FEMALE
}
public class EnumSex {
    public static void main(String[] args) {
        Person person = new Person("张三",20,Sex.MALE);
        System.out.println(person);
        switch (Sex1.FEMALE) {
            case MALE:
                System.out.println("男人");
                break;
            case FEMALE:
                System.out.println("女人");
                break;
                default:
                    System.out.println("输入有误");
                    break;
        }
    }

}
