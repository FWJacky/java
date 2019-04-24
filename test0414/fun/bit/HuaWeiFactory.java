package fun.bit;

/**
 * @ClassName HuaWeiFactory
 * @Description TODO
 * @Author L
 * @Date 2019/4/14 12:45
 * @Version 1.0
 **/
class HuaWeiFactory implements PhoneFactory {
    public Phone createPhone() {
        return new HuaWei();
    }
}
