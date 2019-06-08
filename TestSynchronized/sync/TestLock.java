package TestSynchronized.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName TestLock
 * @Description TODO
 * @Author L
 * @Date 2019/6/8 23:29
 * @Version 1.0
 **/
public class TestLock {
    /*
     lock
        c++
        java
        js
        mysql
      unlock

      lock
        game
      unlock

      正常程序：加锁、解锁、异常情况正常解锁
      相当于数据库中的开始事务  CURD （回滚、提交）   结束事务
     **/

    public static void main(String[] args) {
        Runnable runnable = new TickLockRunnable();
        new Thread(runnable,"黄牛A").start();
        new Thread(runnable,"黄牛B").start();
        new Thread(runnable,"黄牛C").start();
    }
}

class TickLockRunnable implements Runnable{
    private int tick = 10;
    //final修饰  防止被修改
    private final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while(this.tick>0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //假设这有一大堆代码
            /*可以这么写,但是这种写法存在逻辑上的问题，如果出现死锁状态，则释放不了锁*/
//            this.lock.lock();
//            if(this.tick>0) {
//                System.out.println(Thread.currentThread().getName() +" 买票，剩余"+(--this.tick));
//            }
//            this.lock.unlock();
            /*一般这么写*/
            this.lock.lock();
            try {
                if(this.tick>0) {
                    System.out.println(Thread.currentThread().getName() + " 买票，剩余"+(--this.tick));
                }
            }finally {
                this.lock.unlock();
            }
        }
    }
}