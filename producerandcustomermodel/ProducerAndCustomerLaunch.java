package com.github.producerandcustomermodel;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName ProducerAndCustomerLaunch
 * @Description TODO
 * @Author L
 * @Date 2019/7/6 17:36
 * @Version 1.0
 **/
public final class ProducerAndCustomerLaunch {

    public ProducerAndCustomerLaunch() {
    }

    public static void run(int producers,int customers){
        System.out.println("生产者："+producers + " 消费者："+customers);
        Queue<Goods> queue = new LinkedList<>();
        Runnable customer = new Customer(queue);
        Runnable producer = new Producer(queue);

        for (int i = 0; i < producers; i++) {
            new Thread(producer,"生产者-"+i).start();
        }

        for (int i = 0; i < customers; i++) {
            new Thread(customer,"消费者-"+i).start();
        }
    }
}
