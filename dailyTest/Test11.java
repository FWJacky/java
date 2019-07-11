package com.github.dailyTest;

/**
 * @ClassName Test11
 * @Description TODO
 * @Author L
 * @Date 2019/7/4 23:30
 * @Version 1.0
 **/
public class Test11 {
//    public void code(){
    //    String str = new String("good");
//    char[] ch = {'a','b','c'};
//
//    public static void main(String[] args) {
//        Test11 t = new Test11();
//        t.opera(t.str, t.ch);
//        System.out.print(t.str+" and ");
//        System.out.print(t.ch);
//    }
//
//    public void opera(String str,char[] ch) {
//        str = "test ok";
//        ch[0] = 'g';
//    }
//    }

//    public static void main(String[] args) throws Exception {
//        int a = 2;
//        int b = 0;
//        System.out.println("1. 计算开始前");
//        try{
//            throw new Exception("加法异常");
//        }catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            System.out.println("[finally]不管怎样都执行");
//        }
//        System.out.println("3. 计算结束后");
//    }

    public static void main(String[] args) {
        System.out.println(new B().getValue());
    }

    static class A {
        protected int value;

        public A(int v) {
            setValue(v);
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getValue() {
            try {
                value++;
                return value;
            } catch (Exception e) {
                System.out.println(e.toString());
            } finally {
                this.setValue(value);
                System.out.println(value);
            }
            return value;
        }
    }

    static class B extends A {
        public B() {
            super(5);
            setValue(getValue() - 3);
        }

        public void setValue(int value) {
            super.setValue(2 * value);
        }
    }



    }
