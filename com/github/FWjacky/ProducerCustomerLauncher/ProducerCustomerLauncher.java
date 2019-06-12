package com.github.FWjacky.ProducerCustomerLauncher;

import com.github.FWjacky.customer.Customer;
import com.github.FWjacky.goods.Goods;
import com.github.FWjacky.producer.Producer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName ProducerCustomerLauncher
 * @Description TODO
 * @Author L
 * @Date 2019/6/11 21:12
 * @Version 1.0
 **/
public final class ProducerCustomerLauncher {

    private ProducerCustomerLauncher() {
    }

    public static void run(int producers, int customers) {
        System.out.println("生产者数量：" + producers + " 消费者数量：" + customers);
        Queue<Goods> queue = new LinkedList<>();
        Runnable producer = new Producer(queue);
        Runnable customer = new Customer(queue);

        for (int i = 0; i < producers; i++) {
            new Thread(producer, "生产者-" + i).start();
        }

        for (int i = 0; i < customers; i++) {
            new Thread(customer, "消费者-" + i).start();
        }
    }

}
