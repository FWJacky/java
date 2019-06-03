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

    private final String title;

    public MyThread(String title) {
        this.title = title;
    }

    //所有线程从此处开始执行
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.title + " " + i);
        }
    }
}
