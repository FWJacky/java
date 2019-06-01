package jcf;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName TestQueue
 * @Description TODO
 * @Author L
 * @Date 2019/6/1 19:48
 * @Version 1.0
 **/
public class TestQueue {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println("查看队列大小："+queue.size());
        System.out.println("查看队头："+queue.peek());
        System.out.println("队列是否为空："+queue.isEmpty());
        System.out.println("出队："+queue.poll());//1
        System.out.println("出队："+queue.poll());//2
        System.out.println("出队："+queue.poll());//3
        System.out.println("出队："+queue.poll());//4
        //null  当队列为空时，出栈返回null
        System.out.println("出队："+queue.poll());
    }
}
