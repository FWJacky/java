package TestSynchronized.sync;

/**
 * @ClassName TestSync
 * @Description TODO
 * @Author L
 * @Date 2019/6/8 20:05
 * @Version 1.0
 **/
public class TestSync {

    public static void main(String[] args) {

        //此时，线程共用同一个对象
//        Sync sync = new Sync();
//        for (int i = 0; i < 3; i++) {
//            SyncThread st = new SyncThread(sync);
//            Thread thread = new Thread(st, "Thread-Sync-" + i);
//            thread.start();
//        }

//        for (int i = 0; i < 3; i++) {
//            //传入到SyncThread中的对象必须是同一个对象
//            SyncThread st = new SyncThread(sync);
//            Thread thread = new Thread(st,"Thread-Sync-" +i);
//            thread.start();
//        }

        /**如果多线程执行的是run方法中的代码，则创建多线程时，需要传入run方法所在类的同一个实例化对象
         * 如果多线程执行的是run方法中调用的方法，则创建多线程时，需要传入run方法所调用的方法所在类的同一个实例化对象
         * 总结：必须传入synchronized关键字所在类的同一个实例化对象*/
//        for (int i = 0; i < 3; i++) {
//            SyncT syncT = new SyncT();
//            Thread thread = new Thread(syncT, "Thread-SynT-" + i);
//            thread.start();
//        }

//        for (int i = 0; i < 3; i++) {
//            Sync1 sync1 = new Sync1();
//            SyncThread1 st1 = new SyncThread1(sync1);
//            Thread thread = new Thread(st1, "Thread-Sync1-" + i);
//            thread.start();
//        }
        for (int i = 0; i < 3; i++) {
            Thread thread = new SyncThread2();
            thread.setName("Thread-Sync2-"+i);
            thread.start();
        }
    }
}

class Sync {
    //多线程访问同一个Sync对象的test方法，同一时间只能有一个线程方法
    //成员方法（非静态方法） => 锁的是类的实例化对象
    //静态方法  => 锁的是类
    public synchronized void test() {
        System.out.println("Sync test 方法在线程：" + Thread.currentThread().getName() + "开始执行");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Sync test 方法在线程：" + Thread.currentThread().getName() + "结束执行");
    }
}

class SyncThread extends Thread {
    private final Sync sync;

    SyncThread(Sync sync) {
        this.sync = sync;
    }

    @Override
    public void run() {
        sync.test();
    }
}

class SyncT extends Thread {

    @Override
    public void run() {
        synchronized (this) {
            System.out.println("Sync test 方法在线程：" + Thread.currentThread().getName() + "开始执行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Sync test 方法在线程：" + Thread.currentThread().getName() + "结束执行");
        }
    }
}

class Sync1 {
    public void test() {
        //Sync.class -> 只有一个
        //Sync1.class -> CLass 对象 -> Sync1 -> 全局锁
        //使用全局锁，不需要考虑Sync1的实例化对象是否是同一个
        synchronized (Sync1.class) {
            System.out.println("Sync test 方法在线程：" + Thread.currentThread().getName() + "开始执行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Sync test 方法在线程：" + Thread.currentThread().getName() + "结束执行");
        }
    }
}

class SyncThread1 extends Thread {
    private final Sync1 sync1;

    SyncThread1(Sync1 sync1) {
        this.sync1 = sync1;
    }

    @Override
    public void run() {
        //在run方法中使用synchronized关键字时 Sync1的实例化对象必须为同一个
//        synchronized (sync1){
        sync1.test();
//        }
    }
}

class SyncThread2 extends Thread {
    @Override
    public void run() {
        Sync1 sync1 = new Sync1();
        sync1.test();
    }
}
