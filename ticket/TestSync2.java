package ticket;

/**
 * @ClassName TestSync2
 * @Description TODO  同步普通对象和Class对象    同步普通对象一般是在run方法中被调用的方法的代码块中使用synchronized关键字，同步该类的实例化对象
 *              TODO  同步Class对象   是在run方法中被调用的方法的代码块中使用synchronized关键字，同步该类的Class对象，即全局锁
 * @Author L
 * @Date 2019/6/8 18:13
 * @Version 1.0
 **/
public class TestSync2 {
    public static void main(String[] args) {

        Sync sync = new Sync();
        MyThread2 mt = new MyThread2(sync);
        Thread thread1 = new Thread(mt,"黄牛A");
        Thread thread2 = new Thread(mt,"黄牛B");
        thread1.start();
        thread2.start();
    }
}

class MyThread2 extends Thread {
    private Sync sync;

    MyThread2(Sync sync) {
        this.sync = sync;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            this.sync.buyTicket();
        }
    }


}

class Sync {
    private Integer ticket = 10;

    //同步普通对象
//    public void buyTicket() {
//        synchronized (this) {
//            if (this.ticket > 0) {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + "买票，剩余" + (--this.ticket));
//            }
//        }
//    }

    //同步Class对象
    public void buyTicket() {
        synchronized (Sync.class) {
            if (this.ticket > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "买票，剩余" + (--this.ticket));
            }
        }
    }
}
