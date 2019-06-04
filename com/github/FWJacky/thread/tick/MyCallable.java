package com.github.FWJacky.thread.tick;

import java.util.concurrent.Callable;

/**
 * @ClassName MyCallable
 * @Description TODO
 * @Author L
 * @Date 2019/6/3 23:40
 * @Version 1.0
 **/
public class MyCallable implements Callable<String> {

    private int ticket = 10;

    //这里的返回值类型和return的类型有关
    @Override
    public String call() throws Exception {
        while(ticket>0) {
            System.out.println("剩余票数：" + this.ticket--);
        }
        return "票卖完了，下次吧。。。";
    }


    public Integer function1 () {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum+=i;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sum;
    }
}
