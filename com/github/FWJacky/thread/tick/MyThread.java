package com.github.FWJacky.thread.tick;

/**
 * @ClassName Thread
 * @Description TODO
 * @Author L
 * @Date 2019/6/3 22:24
 * @Version 1.0
 **/
//线程主类
public class MyThread extends Thread {

//    private final String title;
    private int ticket = 10;

    public MyThread() {
    }

//    public MyThread(String title) {
//        this.title = title;
//    }

    //所有线程从此处开始执行
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
