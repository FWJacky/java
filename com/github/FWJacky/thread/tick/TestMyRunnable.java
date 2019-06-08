package com.github.FWJacky.thread.tick;

import java.time.LocalDateTime;

/**
 * @ClassName TestMyRunnable
 * @Description TODO
 * @Author L
 * @Date 2019/6/3 23:23
 * @Version 1.0
 **/
public class TestMyRunnable {

    /*启动多线程的永远都是Thread类的start()方法*/

    //1. 先创建Runnable接口对象，再将Runnable接口对象传入Thread类的构造方法中
    //Thread类的构造方法是：可以接收Runnable接口对象
    // public Thread(Runnable target) {
    //        init(null, target, "Thread-" + nextThreadNum(), 0);
    //    }
//    public static void code1() {
//        //先执行main方法的方法，再执行多线程
//        System.out.println("这是main方法的开始");
//        Runnable runnable1 = new MyRunnable("MyRunnable1");
//        Runnable runnable2 = new MyRunnable("MyRunnable2");
//        Thread thread1 = new Thread(runnable1);
//        Thread thread2 = new Thread(runnable2);
//        thread1.start();
//        thread2.start();
//        System.out.println("这是main方法的结束");
//    }

    //2. 利用匿名内部类来创建Runnable接口对象
    public static void code2() {
        System.out.println("这是main方法的开始");
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread1 " + i);
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread2 " + i);
                }
            }
        });

        thread1.start();//start0() -> jvm  -> native os thread
        thread2.start();
        System.out.println("这是main方法的结束");
    }

    //3. 利用Lambda表达式进行Runnable对象创建
    public static void code3(){
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread1 " + i);
            }
        }).start();
        new Thread(() -> System.out.println("Hello Thread")).start();
    }


    public static void main(String[] args) {
        //三个线程卖10张票，实现了数据共享
        MyRunnable mr = new MyRunnable();
        new Thread(mr,"黄牛A").start();
        new Thread(mr,"黄牛B").start();
//        new Thread(mr).start();
    }
}
