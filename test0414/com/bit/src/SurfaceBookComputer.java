package com.bit.src;

/**
 * @ClassName SurfaceBookComputer
 * @Description TODO
 * @Author L
 * @Date 2019/4/14 12:16
 * @Version 1.0
 **/ //创建具体工厂SurfaceBookComputer实现接口电脑
class SurfaceBookComputer implements Computer{
    //覆写接口的抽象方法
    public void printComputer() {
        System.out.println("微软电脑");
    }
}
