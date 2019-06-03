package com.github.FWJacky.thread.tick;

import java.util.concurrent.Callable;

/**
 * @ClassName MyCallable
 * @Description TODO
 * @Author L
 * @Date 2019/6/3 23:40
 * @Version 1.0
 **/
public class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum+=i;
        }
        Thread.sleep(1000);
        return sum;
    }
}
