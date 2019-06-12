package com.github.FWjacky.executor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName TestExecutors
 * @Description TODO
 * @Author L
 * @Date 2019/6/12 23:15
 * @Version 1.0
 **/
public class TestExecutors {

    public static void main(String[] args) {

        //固定线程数
//        ExecutorService executorService = Executors.newFixedThreadPool(5);

        //单线程数
//        ExecutorService executorService1 = Executors.newSingleThreadExecutor();

        //无限制线程数
//        ExecutorService executorService2 = Executors.newCachedThreadPool();
//        for (int i = 0; ; i++) {
//            executorService2.execute(()->{
//                System.out.println(Thread.currentThread().getName() +" "+ LocalDateTime.now().toString());
//            });
//        }

        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        //固定延迟执行任务（周期性循环执行任务）
//        service.scheduleWithFixedDelay(()->{
//            System.out.println(Thread.currentThread().getName()+" "+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//        },0L,2L,TimeUnit.SECONDS);

        //在某个时间点执行任务（只执行一次）
        System.out.println(Thread.currentThread().getName()+" " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        service.schedule(()->{
            System.out.println(Thread.currentThread().getName()+" " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        },2L,TimeUnit.SECONDS);
    }
}
