package com.github.producerandcustomermodel;

import java.util.Queue;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Producer
 * @Description TODO
 * @Author L
 * @Date 2019/7/6 17:35
 * @Version 1.0
 **/
public class Producer implements Runnable {

    private final Queue<Goods> queue;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public Producer(Queue<Goods> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true) {
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                lock.lockInterruptibly();
                if(this.queue.size()>=10) {
                    System.out.println(Thread.currentThread().getName()+" 容器已满，停止生产，加快消费");
                    condition.await();
                }else {
                    String id = UUID.randomUUID().toString();
                    String name = "包子";
                    Double price = new Random().nextDouble();
                    Goods goods = new Goods(id,name,price);
                    System.out.println(Thread.currentThread().getName()+" 生产商品 "+goods);
                    this.queue.add(goods);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
