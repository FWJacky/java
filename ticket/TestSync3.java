package ticket;

/**
 * @ClassName TestSync3
 * @Description TODO  同步方法   是指用synchronized关键字修饰方法  如果是静态方法，则锁住的是类对象；如果是实例方法，则锁住的是类的实例化对象
 * @Author L
 * @Date 2019/6/8 19:18
 * @Version 1.0
 **/
public class TestSync3 {

    public static void main(String[] args) {
        Sync1 sync1 = new Sync1();
        MyThread3 mt = new MyThread3(sync1);
        Thread thread1 = new Thread(mt,"黄牛A");
        Thread thread2 = new Thread(mt,"黄牛B");
        thread1.start();
        thread2.start();
    }
}

class MyThread3 extends Thread{
    private Integer ticket = 10;
    private Sync1 sync1;

    MyThread3(Sync1 sync1) {
        this.sync1 = sync1;
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            this.sync1.buyTicket();
        }
    }

    //同步方法
//    public synchronized void buyTicket(){
//        if(this.ticket>0) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() +" 买票，剩余"+ (--this.ticket));
//        }
//    }
}


class Sync1 {
    private Integer ticket = 10;
    //同步方法
    public synchronized void buyTicket(){
        if(this.ticket>0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 买票，剩余"+(--this.ticket));
        }
    }
}

