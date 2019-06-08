package ticket;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName TestLock
 * @Description TODO  编程式Lock
 * @Author L
 * @Date 2019/6/8 19:27
 * @Version 1.0
 **/
public class TestLock {

    public static void main(String[] args) {
        MyThread4 mt = new MyThread4();
        Thread thread1 = new Thread(mt, "黄牛A");
        Thread thread2 = new Thread(mt, "黄牛B");
        thread1.start();
        thread2.start();
    }
}

class MyThread4 extends Thread {
    private Integer ticket = 10;
    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            lock.lock();
            try {
                if (this.ticket > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 买票，剩余" + (--this.ticket));
                }
            }finally {
                lock.unlock();
            }
        }
    }
}
