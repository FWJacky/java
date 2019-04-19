package com.bit.game;

import java.util.Scanner;

/**
 * @ClassName Game
 * @Description TODO
 * @Author L
 * @Date 2019/4/6 14:47
 * @Version 1.0
 **/
public class Game {
    Person person = new Person();
    Computer computer = new Computer();
    public void playThreeTime() {
        int count =0;
        person.setName("二狗子");
        computer.setName("创世纪");
        while (count<3) {
            String pFist=person.fist();
            String cFist=computer.fist();
            if(pFist.equals(cFist)) {
                System.out.println("平局");
            }
            else if(pFist.equals("石头") && cFist.equals("剪刀")
                    || pFist.equals("剪刀")&&cFist.equals("布")
                    ||pFist.equals("布")&&cFist.equals("石头")) {
                System.out.println(person.getName()+"胜利");
                person.addScore();
            }else {
                System.out.println(computer.getName()+"胜利");
                computer.addScore();
            }
            count ++;
        }

    }
    public void getResult()  {
        int pScore=person.getScore();
        int cScore=computer.getScore();
        if(pScore>cScore) {
            System.out.println(person.getName()+"最终取得胜利");
        }else if(pScore<cScore) {
            System.out.println(computer.getName()+"最终取得胜利");
        }else {
            System.out.println("双方平局");
        }
        System.out.println(person.getName()+":"+computer.getName()+"="+pScore+":"+cScore);
    }
    public void start() {
        while(true) {
            playThreeTime();
            getResult();
            System.out.println("是否继续？");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.next();
            if(str.equals("是")) {
                continue;
            }else {
                break;
            }
        }
    }
}
