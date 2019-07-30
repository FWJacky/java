package com.github.dailyTest;

/**
 * @ClassName SingleTon
 * @Description TODO
 * @Author L
 * @Date 2019/7/8 19:06
 * @Version 1.0
 **/
public class SingleTon {
    private int age;
    private String name;
    private static volatile SingleTon singleTon;
    private SingleTon(){
        age = 0;
        name = null;
    }
    public static SingleTon getInstance() {
        if(singleTon == null) {
            synchronized (SingleTon.class) {
                if(singleTon == null) {
                    // a.堆开空间
                    // b.属性初始化
                    // c.栈开空间指向堆内存(此时single !=null)
                    singleTon = new SingleTon();//这里存在指令重排问题，有可能出现c在b之前执行，就是导致产生的single!=null，但是属性没有初始化
                }
            }
        }
        return singleTon;
    }
}
