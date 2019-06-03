package com.github.FWJacky.thread.tick;

/**
 * @ClassName TestMyThread
 * @Description TODO
 * @Author L
 * @Date 2019/6/3 22:40
 * @Version 1.0
 **/
public class TestMyThread {

    public static void main(String[] args) {
        //main方法中的先执行
        System.out.println("这是main方法的开始");
        MyThread myThread1 = new MyThread("thread1");
        MyThread myThread2 = new MyThread("thread2");
        MyThread myThread3 = new MyThread("thread3");
        //只是做了一个简单的顺序打印
//        myThread1.run();
//        myThread2.run();
//        myThread3.run();
        //启动多线程，线程对象交替执行
        myThread1.start();
        myThread2.start();
        myThread3.start();
        System.out.println("这是main方法的结束");
    }
}
