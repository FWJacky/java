package fun1;

/**
 * @ClassName fun1.IphoneFactory
 * @Description TODO
 * @Author L
 * @Date 2019/4/14 11:53
 * @Version 1.0
 **/
public class IphoneFactory implements PhoneFactory {
    public Phone createPhone() {
        return new Iphone();
    }
    public OperatingSystem createSystem() {
        return new IphoneSystem();
    }
}
