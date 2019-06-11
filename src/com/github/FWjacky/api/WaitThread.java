package com.github.FWjacky.api;

/**
 * @ClassName WaitThread
 * @Description TODO
 * @Author L
 * @Date 2019/6/11 19:41
 * @Version 1.0
 **/
public class WaitThread extends Thread{

    final Object object;

    WaitThread(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (this.object){
            System.out.println(Thread.currentThread().getName() +"开始执行");
            try {
                this.object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ "结束执行");
        }
    }
}
