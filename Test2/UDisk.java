/**
 * @ClassName UDisk
 * @Description TODO
 * @Author L
 * @Date 2019/4/11 15:55
 * @Version 1.0
 **/
public class UDisk implements USB {
    @Override
    public void setup() {
        System.out.println("安装U盘驱动程序");
    }

    @Override
    public void work() {
        System.out.println("U盘开始工作");
    }
}
