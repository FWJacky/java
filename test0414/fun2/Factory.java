package fun2;

/**
 * @ClassName Factory
 * @Description TODO
 * @Author L
 * @Date 2019/4/14 14:16
 * @Version 1.0
 **/
class Factory {
    public static ISubject getInstance() {
        return new ProxySubject(new RealSubject());
    }
}
