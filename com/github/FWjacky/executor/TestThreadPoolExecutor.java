package com.github.FWjacky.executor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName TestThreadPoolExecutor
 * @Description TODO
 * @Author L
 * @Date 2019/6/12 19:42
 * @Version 1.0
 **/
public class TestThreadPoolExecutor {

    public static void main(String[] args) {

        //ArrayBlockingQueue<>()是基于数组结构的阻塞队列，容量有限制
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
//                5,10,1,TimeUnit.MINUTES,
//                new ArrayBlockingQueue<>(15),
//                new ThreadPoolExecutor.AbortPolicy()
//        );
//
//        for (int i = 0; i < 50; i++) {
//            final int tmp = i;
//            threadPoolExecutor.execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName() + " " + tmp);
//                }
//            });
//        }

        //LinkedBlockingQueue<>()是基于链表结构的阻塞队列，容量不受限制
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5, 10, 1, TimeUnit.MINUTES,
                new LinkedBlockingQueue<>(),
                //自定义线程工厂
                new ThreadFactory() {
                    final AtomicInteger id = new AtomicInteger(0);
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName("线程-"+id.getAndIncrement());
                        return thread;
                    }
                },
                //饱和策略
        new ThreadPoolExecutor.AbortPolicy()
        );
//
//        for (int i = 0; i < 50; i++) {
//            final int tmp = i;
//            threadPoolExecutor.execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName() + " " + tmp);
//                }
//            });
//        }

        //创建一个集合，用来接收将来执行的任务的结果处理
        List<Future> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final int tmp = i;
            final Future<String> future = threadPoolExecutor.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(new Random().nextInt(5000));
                    return "任务编号："+ tmp +" 时间："+ LocalDateTime.now().toString();
                }
            });
            //如果不将执行的任务的结果进行处理，直接用future.get()会导致线程阻塞
            //此时的处理方法是，将将来执行的任务的结果处理放到集合中
            futureList.add(future);
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //假设sleep之后，任务都执行完成了
        //此时打印任务执行后的结果
//        for (Future future : futureList) {
//            try {
//                System.out.println(future.get());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        }

        List<Runnable> runnables = threadPoolExecutor.shutdownNow();
        System.out.println(runnables.size());
        System.out.println(threadPoolExecutor.isShutdown());
        System.out.println(threadPoolExecutor.isTerminated());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadPoolExecutor.isTerminated());

        //检查线程池关闭状态的方式有：
        //1. 循环
        while(threadPoolExecutor.isTerminated()) {
            break;
        }
        //2. 定期检查
    }


}
