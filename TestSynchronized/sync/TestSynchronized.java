package TestSynchronized;

/**
 * @ClassName TestSynchronized
 * @Description TODO
 * @Author L
 * @Date 2019/6/8 16:29
 * @Version 1.0
 **/
public class TestSynchronized {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            //多个线程同时执行不同对象的同步代码块时，synchronized不起作用
            Thread thread = new MyThread();
            thread.start();
        }
    }
}

class Sync{
    public synchronized void test(){
        System.out.println(Thread.currentThread().getName() + " test方法开始执行");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " test方法执行结束");
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        Sync sync = new Sync();
        sync.test();
    }
}
