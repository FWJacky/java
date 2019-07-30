package com.github.dailyTest;

/**
 * @ClassName Test18
 * @Description TODO
 * @Author L
 * @Date 2019/7/9 11:01
 * @Version 1.0
 **/

class A {
    protected int value;
    public A(int value) {
        setValue(value);
    }

    public void setValue(int value) {
        this.value = value; //5 //10 //11
    }

    public int getValue() {
        try{
            value++; //6 //11
            return value;  //11
        }catch (Exception e) {
            System.out.println(e.toString());
        }finally {
            setValue(value); //value = 6
            System.out.println(value);
        }
        return value;
    }
}
public class Test18 extends A{
    public Test18(int value) {
        super(value); //value=5
        setValue(getValue()-3);
    }

    public void setValue(int value) {
        super.setValue(value*2);//10
    }

    public static void main(String[] args) {
        System.out.println(new Test18(5).getValue());
    }
}
