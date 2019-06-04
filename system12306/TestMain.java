package system12306;

/**
 * @ClassName TestMain
 * @Description TODO
 * @Author L
 * @Date 2019/6/4 0:32
 * @Version 1.0
 **/
public class TestMain {

    public static void main(String[] args) {
        Window window1 = new Window("北京北站");
        Window window2 = new Window("北京西站");
        Window window3 = new Window("北京南站");
        window1.start();
        window2.start();
        window3.start();
    }
}
