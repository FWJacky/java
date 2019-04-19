package com.bit.game;

import java.util.Scanner;

/**
 * @ClassName Person
 * @Description TODO
 * @Author L
 * @Date 2019/4/6 14:46
 * @Version 1.0
 **/
public class Person {
    private  String name;
    private int score;

    public String getName() {
        return name;
    }
//
    public void setName(String name) {
        this.name = name;
    }
//    public Person(String name) {
//        this.name = name;
//    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

//    public Person(String name,int score) {
//        System.out.println(name);
//        System.out.println(score);
//    }
    public  String fist() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入出的招数：石头，剪刀，布");
        String str = scanner.nextLine();
        return str;
    }
    public int addScore() {
        this.score ++;
        return score;
    }

}
