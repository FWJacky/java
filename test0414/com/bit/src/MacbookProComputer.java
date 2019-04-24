package com.bit.src;

/**
 * @ClassName MacbookProComputer
 * @Description TODO
 * @Author L
 * @Date 2019/4/14 12:16
 * @Version 1.0
 **/ //创建具体工厂MacbookComputer实现接口电脑
class MacbookProComputer implements Computer {
    //覆写接口的抽象方法
    public void printComputer() {
        System.out.println("苹果电脑");
    }
}
