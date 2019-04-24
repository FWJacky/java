package fun.bit;

/**
 * @ClassName IphoneFactory
 * @Description TODO
 * @Author L
 * @Date 2019/4/14 12:45
 * @Version 1.0
 **/
class IphoneFactory implements PhoneFactory {
    public Phone createPhone() {
        return new Iphone();
    }
}
