package fun2;

public class Test {
    public static void main(String[] args) {
        ISubject subject = Factory.getInstance();
        subject.buyPhone();

        String str = new String("hello").intern();
        String str2 = "hello";
        System.out.println(str==str2);
    }
}


