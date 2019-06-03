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
    private final String title;

    public MyRunnable(String title) {
        this.title = title;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.title + " " + i);
        }
    }
}
