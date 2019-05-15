package com.bit.FunctionInterface;

import java.util.Random;
import java.util.function.*;

/**
 * @ClassName TestBuildInFuction
 * @Description TODO
 * @Author L
 * @Date 2019/5/14 23:02
 * @Version 1.0
 **/
public class TestBuildInFuction {

    //功能型接口
    public static void function() {
        Function<Integer,String > fun = (x) -> {
            return String.valueOf(x);
        };
        fun = String::valueOf;
        System.out.println(fun.apply(20));
    }

    //供给型接口
    public static void supplier() {
        Supplier<String> sup = () -> {
            return "hello";
        };
//        sup = "hello"::toUpperCase;
        System.out.println(sup.get());
    }

    //消费型接口
    public static void consumer() {
        Consumer<Integer> con = (x) -> {
            System.out.println(x);
        };
        con = System.out::println;
        con.accept(22);
    }

    //断言型接口
    public static void predicate() {
        Predicate<String> pre = (x) -> {
            if(x == null) {
                return false;
            }else {
                return x.length() > 2;
            }
        };
        System.out.println(pre.test("hello"));
        System.out.println(pre.test(""));
    }
    public static void main(String[] args) {
//        //功能型接口——输入一个数据，而后将数据处理后进行输出
//        Function<Integer,String> function = String::valueOf;
//        System.out.println(function.apply(20));
//        //如果确定操作的数据是int，则使用IntFunction接口
//        IntFunction<String> intFunction = String::valueOf;
//        System.out.println(intFunction.apply(200));
//
//        Function<Integer,String> fun = (x) -> {
//            return String.valueOf(x);
//        };
////        System.out.println(fun.apply(20));
//        Consumer<String> consumer = (x) -> {
//            System.out.println(x);
//        };
//        consumer.accept("hello");
//        print((p) -> {
//            System.out.println("***");
//            return String.valueOf(p);
//        },20);
//        print(()->{return "hello";});

        Supplier<String> supplier = () -> {
            Random random = new Random();
            return String.valueOf(random.nextInt(200));
        };
        Predicate<Supplier<String>> predicate = (x) -> {
            String str = x.get();
            System.out.println(str);
            if(str == null) {
                return false;
            }else {
                return str.length() > 2;
            }
        };
        System.out.println(predicate.test(supplier));
    }
    public static void print(Function<Integer,String> function,Integer p) {
        System.out.println(function.apply(p));
    }
    public static void print(Supplier<?> supplier) {
        System.out.println(supplier.get());
    }
}

