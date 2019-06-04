package com.github.FWJacky.thread.tick;

/**
 * @ClassName MyRunnable
 * @Description TODO
 * @Author L
 * @Date 2019/6/3 23:21
 * @Version 1.0
 **/
public class MyRunnable implements Runnable {

    //单例模式
//    private final String title;
    private int ticket = 10;

//    public MyRunnable(String title) {
//        this.title = title;
//    }

    @Override
    public void run() {
        this.function2();
    }

//    public void function1() {
//        for (int i = 0; i < 10; i++) {
//            System.out.println(this.title + " " + i);
//        }
//    }

    public void function2() {
        while (this.ticket > 0) {
            System.out.println("剩余票数：" + this.ticket--);
        }
    }
}
