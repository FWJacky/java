package fun1;

/**
 * @ClassName fun1.PhoneFactory
 * @Description TODO
 * @Author L
 * @Date 2019/4/14 11:53
 * @Version 1.0
 **/
interface PhoneFactory {
    Phone createPhone();
    OperatingSystem createSystem();
}
