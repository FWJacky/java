/**
 * @ClassName Computer
 * @Description TODO
 * @Author L
 * @Date 2019/4/11 15:58
 * @Version 1.0
 **/
public class Computer {
    public void plugin(USB usb) {
        usb.setup();
        usb.work();
    }
}
