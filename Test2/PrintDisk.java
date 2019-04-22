/**
 * @ClassName PrintDisk
 * @Description TODO
 * @Author L
 * @Date 2019/4/11 15:55
 * @Version 1.0
 **/
public class PrintDisk implements USB {
    @Override
    public void setup() {
        System.out.println("安装打印机驱动程序");
    }

    @Override
    public void work() {
        System.out.println("打印机开始工作");
    }
}
