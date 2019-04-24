package fun1;

/**
 * @ClassName fun1.HuaWeiFactory
 * @Description TODO
 * @Author L
 * @Date 2019/4/14 11:53
 * @Version 1.0
 **/
public class HuaWeiFactory implements PhoneFactory {
    public Phone createPhone() {
        return new HuaWei();
    }
    public OperatingSystem createSystem() {
        return new AndroidSystem();
    }
}
