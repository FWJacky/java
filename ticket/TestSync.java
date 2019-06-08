package ticket;

/**
 * @ClassName TestSync
 * @Description TODO  同步对象  同步对象是在run方法中使用synchronized关键字进行同步 一般是同步this对象
 * @Author L
 * @Date 2019/6/8 17:55
 * @Version 1.0
 **/
public class TestSync {

    public static void main(String[] args) {
        MyThread mt = new MyThread();
        Thread thread1 = new Thread(mt,"黄牛A");
        Thread thread2 = new Thread(mt,"黄牛B");
        thread1.start();
        thread2.start();
    }
}

class MyThread extends Thread{
    private Integer ticket = 10;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            //同步对象
            synchronized (this) {
                if(this.ticket>0) {
                    System.out.println(Thread.currentThread().getName() + "买票，剩余 " +(--this.ticket));
                }
            }
        }
    }
}