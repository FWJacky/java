package TestSynchronized.lock;



/**
 * @ClassName TestDeadLock
 * @Description TODO
 * @Author L
 * @Date 2019/6/8 23:51
 * @Version 1.0
 **/
public class TestDeadLock {

    public static void main(String[] args) {
        final Book book = new Book();
        final Pen pen = new Pen();
        Thread threadA = new ThreadA(pen,book);
        threadA.setName("Thread-A");
        Thread threadB = new ThreadB(pen,book);
        threadB.setName("Thread-B");

        threadA.start();
        threadB.start();

    }
}

class Pen {
    private String name ="笔";

    public String getName() {
        return name;
    }
}

class Book{
    private String name = "本";

    public String getName() {
        return name;
    }
}

class ThreadA extends Thread{
    private final Pen pen;
    private final Book book;

    ThreadA(Pen pen, Book book) {
        this.pen = pen;
        this.book = book;
    }

    @Override
    public void run() {
        synchronized (this.pen) {
            System.out.println(Thread.currentThread().getName()+ " 有笔，缺个本");
            synchronized (this.book){
                System.out.println(Thread.currentThread().getName()+ " 有笔，有本");
            }
        }
    }
}

class ThreadB extends Thread{
    private final Pen pen;
    private final Book book;

    ThreadB(Pen pen, Book book) {
        this.pen = pen;
        this.book = book;
    }

    @Override
    public void run() {
        synchronized (this.book) {
            System.out.println(Thread.currentThread().getName()+ " 有本，缺个笔");
            synchronized (this.pen){
                System.out.println(Thread.currentThread().getName()+ " 有本，有笔");
            }
        }
    }
}