package com.github.FWjacky.producer;

import com.github.FWjacky.goods.Goods;

import java.util.Queue;
import java.util.Random;
import java.util.UUID;

/**
 * @ClassName Producer
 * @Description TODO
 * @Author L
 * @Date 2019/6/11 20:23
 * @Version 1.0
 **/
public class Producer implements Runnable{

    final Queue<Goods> queue;

    public Producer(Queue<Goods> queue) {
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
            synchronized (this.queue) {
                if(this.queue.size()>=10) {
                    System.out.println(Thread.currentThread().getName()+ "容器已满 停止生产 加速消费");
                    try {
                        this.queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    //获得随机id的方法
                    //1. 获取当前时间戳
                    //(String)System.currentTimeMillis();
                    //2. UUID
                    String id = UUID.randomUUID().toString();
                    Double price = new Random().nextDouble();
                    Goods goods = new Goods(id,"包子",price);
                    this.queue.add(goods);
                    System.out.println(Thread.currentThread().getName() + "开始生产"+goods);
                }
            }
        }
    }
}
