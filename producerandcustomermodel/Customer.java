package com.github.producerandcustomermodel;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Customer
 * @Description TODO
 * @Author L
 * @Date 2019/7/6 17:36
 * @Version 1.0
 **/
public class Customer implements Runnable {

    private final Queue<Goods> queue;

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public Customer(Queue<Goods> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                lock.lockInterruptibly();
                if(this.queue.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + " 容器已空，停止消费，加快生产！");
                    condition.signalAll();
                }else {
                    Goods goods = this.queue.poll();
                    if(goods!=null) {
                        System.out.println(Thread.currentThread().getName()+ " 消费商品 "+goods);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
