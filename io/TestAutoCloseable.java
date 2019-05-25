package io;

import java.lang.reflect.Member;

/**
 * @ClassName TestAutoCloseable
 * @Description TODO
 * @Author L
 * @Date 2019/5/25 10:19
 * @Version 1.0
 **/

class Message implements AutoCloseable {

    public void print() {
        System.out.println("Message的print()方法调用");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Message的close()方法执行");
    }
}
public class TestAutoCloseable {


    public static void main(String[] args) {
        try(Message message = new Message()) {
            message.print();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
