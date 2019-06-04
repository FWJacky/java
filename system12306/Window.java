package system12306;

/**
 * @ClassName Window
 * @Description TODO
 * @Author L
 * @Date 2019/6/3 23:58
 * @Version 1.0
 **/
public class Window extends Thread {

    //窗口名字
    private String windowName;

    public Window(String windowName) {
        this.windowName = windowName;
    }

    public void run() {
        this.sellTicket();
    }

    public void sellTicket() {
        while (true) {
            System12306 sys = System12306.getInstance();
            Ticket ticket = sys.getTicket();
            if (ticket == null) {
                System.out.println("对不起"+windowName+"窗口车票已售完");
                break;
            }
            System.out.println("从"+windowName+"售出："+ticket);
        }
    }
}
