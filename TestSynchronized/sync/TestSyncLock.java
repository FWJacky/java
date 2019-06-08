package TestSynchronized.sync;

/**
 * @ClassName TestSyncLock
 * @Description TODO
 * @Author L
 * @Date 2019/6/8 23:12
 * @Version 1.0
 **/
public class TestSyncLock {

    public static void main(String[] args) {
        //同一个对象
        final Object lock = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " 执行开始");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 执行结束");
                }
            }
        }, "线程A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " 执行开始");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 执行结束");
                }
            }
        }, "线程B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " 执行开始");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 执行结束");
                }
            }
        }, "线程C").start();
    }
}
