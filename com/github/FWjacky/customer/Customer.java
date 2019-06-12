package com.github.FWjacky.customer;

import com.github.FWjacky.goods.Goods;

import java.util.Queue;

/**
 * @ClassName Customer
 * @Description TODO
 * @Author L
 * @Date 2019/6/11 20:35
 * @Version 1.0
 **/
public class Customer implements Runnable {

    final Queue<Goods> queue;

    public Customer(Queue<Goods> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this.queue) {
                if(this.queue.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + "容器已满 停止消费 加速生产");
                    this.queue.notifyAll();
                }else {
                   Goods goods =  this.queue.poll();
                    if(this.queue.isEmpty()) {
                        System.out.println(Thread.currentThread().getName() +"消费商品"+goods);
                    }
                }
            }
        }
    }
}
