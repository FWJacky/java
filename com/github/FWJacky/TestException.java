package com.github.FWJacky;

/**
 * @ClassName TestException
 * @Description TODO
 * @Author L
 * @Date 2019/5/12 11:04
 * @Version 1.0
 **/
public class TestException {
    public static void main(String[] args) {
//        System.out.println("1. 数字计算开始前");
//        try {
//            System.out.println("2. 进行数学计算：" + 10 / 0);
//        } catch (ArithmeticException e) {
//            e.printStackTrace();
//        }
//        System.out.println("3. 数学计算结束后");
//        try {
//            System.out.println(calculate(10,0));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        String str = "100";
        int num = Integer.parseInt(str);
        System.out.println(num*2);
    }

//    public static int calculate(int x,int y) throws Exception {
//        int result = 0;
//        System.out.println("1. 计算前****");
//        try{
//            result = x / y;
//        }finally {
//            System.out.println("2.计算结束####");
//        }
//        return result;
//    }
}
