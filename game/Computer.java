package com.bit.game;

import java.util.Random;

/**
 * @ClassName Computer
 * @Description TODO
 * @Author L
 * @Date 2019/4/6 14:46
 * @Version 1.0
 **/
public class Computer {
    private String name;
    private int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
//    public Computer(String name,int score) {
//        System.out.println(name);
//        System.out.println(score);
//    }
    public  String fist() {
        Random random = new Random();
        int n = random.nextInt(3)+1;
        String str = null;
        switch (n) {
            case 1:
                System.out.println("石头");
                str = "石头";
                break;
            case 2:
                System.out.println("剪刀");
                str = "剪刀";
                break;
            case 3:
                System.out.println("布");
                str = "布";
                break;
        }
        return str;
    }
    public int addScore() {
        this.score ++;
        return score;
    }
}
