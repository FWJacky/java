package com.github.dailyTest;

public interface IMessage {
    public default void fun() {
        System.out.println("Hello IMessage");
    }

    void print();

    public static IMessage getInstanceOf(){
        return new MessageImpl();
    }
}

class MessageImpl implements IMessage {

    @Override
    public void print() {
        System.out.println("Hello MessageImpl");
    }

    public static void main(String[] args) {
        IMessage message = IMessage.getInstanceOf();
        message.print();
        message.fun();
    }
}
