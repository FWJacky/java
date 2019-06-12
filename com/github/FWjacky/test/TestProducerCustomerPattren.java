package com.github.FWjacky.test;

import com.github.FWjacky.ProducerCustomerLauncher.ProducerCustomerLauncher;
import com.github.FWjacky.customer.Customer;
import com.github.FWjacky.goods.Goods;
import com.github.FWjacky.producer.Producer;

import java.net.Inet4Address;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName TestProducerCustomerPattren
 * @Description TODO
 * @Author L
 * @Date 2019/6/11 20:42
 * @Version 1.0
 **/
public class TestProducerCustomerPattren {

    public static void code1() {
        //容器：Queue
        //生产者
        //消费者
        Queue<Goods> queue = new LinkedList<>();
        Runnable producer = new Producer(queue);
        Runnable customer = new Customer(queue);

        //生产者线程
        for (int i = 0; i < 1; i++) {
            new Thread(producer, "生产者线程-" + i).start();
        }

        //消费者线程
        for (int i = 0; i < 1; i++) {
            new Thread(customer, "消费者线程-" + i).start();
        }
    }

    public static void main(String[] args) {
        int defaultProducers = 5;
        int defaultCustomers = 5;
        int producers = 0;
        int customers = 0;

        if (args.length == 1) {
            try {
                producers = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                producers = defaultProducers;
            }
        }

        if (args.length == 2) {
            try {
                producers = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                producers = defaultProducers;
            }
            try {
                customers = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                customers = defaultCustomers;
            }
        }
        if (producers <= 0) {
            producers = defaultProducers;
        }
        if (customers <= 0) {
            customers = defaultCustomers;
        }

        ProducerCustomerLauncher.run(producers,customers);

    }
}
