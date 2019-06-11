package com.github.FWjacky.api;

/**
 * @ClassName NotifyThread
 * @Description TODO
 * @Author L
 * @Date 2019/6/11 19:46
 * @Version 1.0
 **/
public class NotifyThread extends Thread{

    final Object object;

    public NotifyThread(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (this.object){
            System.out.println(Thread.currentThread().getName() + "开始执行");
            this.object.notify();
            System.out.println(Thread.currentThread().getName() + "结束执行");
        }
    }
}
