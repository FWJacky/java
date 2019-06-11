package com.github.FWjacky.api;

/**
 * @ClassName TestThread
 * @Description TODO
 * @Author L
 * @Date 2019/6/11 19:58
 * @Version 1.0
 **/
public class TestThread {

    public static void main(String[] args) {
        Object object = new Object();
        Thread wait = new WaitThread(object);
        wait.setName("Thread-等待线程");
        Thread notify = new NotifyThread(object);
        notify.setName("Thread-唤醒线程");

        wait.start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        notify.start();
    }
}
