package com.github.FWJacky.thread.tick;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @ClassName TestThreadMethod
 * @Description TODO
 * @Author L
 * @Date 2019/6/5 18:48
 * @Version 1.0
 **/
public class TestThreadMethod {

    public static void code1() {
        //        LocalDateTime now = LocalDateTime.now();
//        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss")));
        Date data = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
    }

    public static void code2(){
        //通过Thread类的setName()方法设置线程名字
//        Thread thread1 = new ThreadMethod();
//        thread1.setName("打印输出线程");
//        thread1.start();

        //通过Thread类的构造方法设置线程名字
//        for (int i = 0; i < 10; i++) {
//            Runnable runnable1 = new RunnableMethod();
//            Thread thread2 = new Thread(runnable1,"线程-"+ i);
//            thread2.start();
//        }
        //线程名称一般设置为：Thread-[业务名称]

        //主程序（程序入口），线程main
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());//当前线程名为main

        //main -> Thread(main)
        //java程序就是一个进程，在jvm中执行，需要有个程序入口，而main方法就是主线程
        //线程分为：用户线程和守护线程   GC（线程）就是守护线程：自动回收内存
    }

    public static void code3(){
        //直接用Lambda表达式创建Runnable对象
        new Thread(()-> {
            System.out.println("Start："+LocalDateTime.now());
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+ " " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("End："+LocalDateTime.now());
        },"Thread-Sleep").start();
    }

    public static void code4(){
        Runnable runnable = ()->{
            System.out.println("Start："+LocalDateTime.now());
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() +" "+i);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //                Thread.yield();
            }
            System.out.println("End："+LocalDateTime.now());
        };

        //这三个线程并不是同时休眠，进入方法的线程对象可能是多个或者一个，他们之间有先后顺序，但是实际的顺序是由CPU决定
        new Thread(runnable,"Thread-Sleep-1").start();
        new Thread(runnable,"Thread-Sleep-2").start();
        new Thread(runnable,"Thread-Sleep-3").start();
    }

    public static void code5(){
        //join()-----线程必须执行完成再执行main线程
        Thread thread = new Thread(new RunnableJoin(),"Thread-B");
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main方法结束");
    }

    public static void code6(){
        /*
         日期的格式化方式有两种：
         1. 通过SimpleDateFormat的构造方法，传入格式
         2. 通过LocalDateTime.now().format(DateTimeFormatter.ofPattern())
         **/

        //日期的格式：
        //2019-06-05 22:43:20
        //2019/06/05 22:43:20
        //2019年06月05日 22:43:20

        //date---日期   time---时间   datetime---日期时间
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(date));//2019-06-05 22:45:29

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE));
    }

    public static void code7(){
        /*三种线程停止方式：标记位、stop、interrupt*/
        RunnableStop runnableStop = new RunnableStop();
        Thread thread = new Thread(runnableStop,"Thread-Stop-1");
        thread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " code");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        runnableStop.setFlag(false);
//        thread.stop();
        thread.interrupt();
        System.out.println(Thread.currentThread().getName() + " 代码执行完啦");
    }

    public static void code8(){
        //        Thread thread1 = new Thread(()-> System.out.println(Thread.currentThread().getName() + " 优先级"+Thread.currentThread().getPriority()),"Thread-1");
//        thread1.setPriority(10);
//        thread1.start();
//        System.out.println(Thread.currentThread().getPriority());

        //此A线程优先级为10  main线程（主线程）优先级为5   而A继承main线程，所以输出后A线程优先级为5
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 优先级" +
                        Thread.currentThread().getPriority());
                Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
                //此B线程优先级继承A线程优先级，为10
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName() + " 优先级" +
                                Thread.currentThread().getPriority());
                        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
                    }
                }, "Thread-Parent-A-Name-is-B").start();
            }
        },"Thread-Parent-Main-Name-is-A").start();
    }

    public static void main(String[] args) {

        //thread-0
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" " + LocalDateTime.now());
                }
            }
        });
//        //必须在线程启动之前调用-----setDaemon(true)设置thread为守护线程
//        //如果isDaemon()返回false，则表示该线程为用户线程，否则为守护线程
        thread.setDaemon(true);
        thread.start();

        //Thread-1
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                    System.out.println(Thread.currentThread().getName()+" "+LocalDateTime.now());
                }
            }
        });
        System.out.println(thread2.getName());
        thread2.start();

        //
        try {
            //给主线程争取时间，如果不设置休眠时间，则非守护线程会直接中断
            //这里休眠10000ms，其实就是线程运行的时间，即主线程休眠的时间，当主线程结束休眠时，就会执行后面的代码
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //中断非守护线程
        thread2.interrupt();
        System.out.println("main代码结束");
    }
}

class RunnableMethod implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +"runnable(implements)");
    }
}

class ThreadMethod extends Thread{
    @Override
    public void run() {
        //this表示ThreadMethod类的对象，getName()获取当前线程的名称
        System.out.println(this.getName() + "thread(extends)");
    }
}

class ThreadSleep implements Runnable {

    @Override
    public void run() {
        System.out.println("代码开始："+LocalDateTime.now());
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            Thread.yield();
            System.out.println(Thread.currentThread().getName() + " 执行了 " + i + "次");
        }
        System.out.println(Thread.currentThread().getName()+"代码结束："+LocalDateTime.now());
    }
}

class RunnableJoin implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "代码开始：" + LocalDateTime.now());
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行了"+i+"次");
        }
        System.out.println(Thread.currentThread().getName() + "代码结束：" + LocalDateTime.now());
    }
}

class RunnableStop implements Runnable{

    private boolean flag = true;
    @Override
    public void run() {
        int i = 0;
        while(flag) {
            try {
                Thread.sleep(1000);//阻塞
                boolean bool = Thread.currentThread().isInterrupted();
                if(bool) {
                    System.out.println("非阻塞状态 "+ bool);
                }
                i++;
                System.out.println(Thread.currentThread().getName() + "执行了" + i + "次");
            } catch (InterruptedException e) {
                e.printStackTrace();
                //阻塞状态
                boolean bool = Thread.currentThread().isInterrupted();
                //false 中断标志位清除
                System.out.println("阻塞状态 " + bool);
                break;
            }
        }
        System.out.println(Thread.currentThread().getName() + " 终于停了");
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

