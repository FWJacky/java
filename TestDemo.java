package com.github;

/**
 * @ClassName TestDemo
 * @Description TODO
 * @Author L
 * @Date 2019/7/9 19:26
 * @Version 1.0
 **/
public class TestDemo {

    public static void main(String[] args) {
        TestHeep testHeep = new TestHeep();
        int[] array = {1,2,3,4,5,21,23,53,22,121,123};
        testHeep.initHeap(array);
//        testHeep.pushHeap(8);
//        testHeep.pushHeap(9);
//        System.out.println(testHeep.popHeap());
//        System.out.println(testHeep.getHeapTop());
//        testHeep.HeapSort();
        testHeep.show();

    }
}
