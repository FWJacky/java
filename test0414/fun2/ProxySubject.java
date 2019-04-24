package fun2;

/**
 * @ClassName ProxySubject
 * @Description TODO
 * @Author L
 * @Date 2019/4/14 14:16
 * @Version 1.0
 **/ //辅助业务
class ProxySubject implements ISubject {
    private ISubject subject;
    public ProxySubject(ISubject subject) {
        this.subject = subject;
    }
    public void producePhone() {
        System.out.println("1.生产华为手机");
    }
    public void afterSale() {
        System.out.println("3.华为售后团队");
    }
    public void buyPhone() {
        this.producePhone();
        this.subject.buyPhone();
        this.afterSale();
    }
}
