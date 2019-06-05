package com.github.FWJacky.thread.tick;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.concurrent.*;

/**
 * @ClassName TestMyCallable
 * @Description TODO
 * @Author L
 * @Date 2019/6/3 23:41
 * @Version 1.0
 **/
public class TestMyCallable {

//    public static void code1(){
//        Callable<Integer> callable = new MyCallable();
//
//        //Runnable  -> run  -> void
//        //Callable  -> run(异步)  -> V(int)  将来
//
//        //FutureTask  -> Runnable
//        FutureTask<Integer> futureTask = new FutureTask<>(callable);
//
//        Thread thread = new Thread(futureTask);
//        thread.start();
//
//        try {
//            Integer sum = futureTask.get(1, TimeUnit.MILLISECONDS);
//            System.out.println(sum);
//        } catch (InterruptedException e) {  //中断
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        }
//        System.out.println("main结束");
//    }

    public static void main(String[] args) {

        //Thread中是run()方法
        //FutureTask中是传入了Callable，且FutureTask中是call()方法
        //FutureTask中的run()方法，调用的是call()方法；run(call)
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
        new Thread(futureTask).start();
        new Thread(futureTask).start();
        try {
            //futureTask.get()是个导致阻塞的事件
            System.out.println(futureTask.get());
        } catch (InterruptedException | ExecutionException e) {//中断
            e.printStackTrace();
        }
        System.out.println("main结束");

    }
}
