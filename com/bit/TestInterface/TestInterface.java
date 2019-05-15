package com.bit.TestInterface;

/**
 * @ClassName TestInterface
 * @Description TODO
 * @Author L
 * @Date 2019/5/15 18:58
 * @Version 1.0
 **/
interface IMessage {
    //使用default定义普通方法，通过对象调用
    public default void fun() {
        System.out.println("hello IMessage");
    }
    //使用static定义静态方法，通过接口名调用
    public static IMessage getIntance() {
        return new Message();
    }
    public void print();
}
class Message implements IMessage {

    @Override
    public void print() {
        System.out.println("Hello Message");
    }
}

public class TestInterface {

    public static int sum(int... array) {
        int result = 0;
        for (int anArray : array) {
            result += anArray;
        }
        return result;
    }

    public static void main(String[] args) {
//        IMessage message = new Message();
//        message.fun();
//        message.print();
//        IMessage.getIntance().fun();
//        IMessage.getIntance().print();
//        IMessage message = IMessage.getIntance();
//        System.out.println(message);
//        System.out.println(IMessage.getIntance());

        System.out.println(sum(1,2,3,4,5));
    }
}
