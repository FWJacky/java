package com.github.FWJacky;

/**
 * @ClassName TestVarArgs
 * @Description TODO
 * @Author L
 * @Date 2019/5/9 15:07
 * @Version 1.0
 **/
public class TestVarArgs {

    public static void main(String[] args) {
        System.out.println(sum());
//        System.out.println(sum(1,2,3));//6
//        System.out.println(sum(1,2,3,4));//10
//        System.out.println(sum(1,2,3,4,5));//15
//        System.out.println(sum(1,2,3,4,5,6));//21
    }

//    public static int sum(int[] array) {
//        int result = 0;
//        for (int i = 0; i < array.length ; i++) {
//            result += array[i];
//        }
//        return result;
//    }

    public static int sum(int... array) {
        int result = 0;
        for (int anArray : array) {
            result += anArray;
        }
        return result;
    }

}
