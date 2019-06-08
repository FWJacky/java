package TestSynchronized.lock;

/**
 * @ClassName TestLock
 * @Description TODO
 * @Author L
 * @Date 2019/6/8 23:42
 * @Version 1.0
 **/
public class TestLock {

    private static StringBuffer sb = new StringBuffer();
//    private final static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        //lock
        /**锁粗化*/
        synchronized (sb){
            //因为StringBuffer是线程安全的，所以每一次append都要解锁开锁
            //为了简化加锁，开锁，可以给他们加把大锁，只加锁开锁一次，这就是锁粗化
            sb.append("a");//lock,unlock
            sb.append("b");//lock,unlock
            sb.append("c");//lock,unlock
        }
        //unlock
        System.out.println(sb.toString());

        /**锁消除：（代码逃逸技术）当堆上的数据不会逃出当前线程，那么认为这段代码是线程安全的，不必加锁。*/
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        sb.append("b");
        sb.append("c");
    }
}
