package 日常练习;
import java.io.IOException;
import java.util.Arrays;

/**
 * @ClassName TestDemo1
 * @Description TODO
 * @Author L
 * @Date 2019/4/4 18:40
 * @Version 1.0
 **/



public class TestDemo1 {
//    private static int x;
//    private static int y;

//    public static void mulTable (int n) {
//        for (int i = 1; i <= n ; i++) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print(i+"*"+j+"="+(i*j)+"\t");
//            }
//            System.out.println();
//        }
//    }


    public static void main(String[] args)  {
//        System.out.println(add(5, 5));
//        myPrint(1);
//        myPrint(2);
//        myPrint(3);
//        myPrint(4);
        System.out.println(sum(100));
//        System.out.println(add(5,5));
//        System.out.println(add(5,5,55));
    }
    public static int add(int x, int y) {
        return x+y;
    }
    public static int add(int x,int y,int z) {
        return x+y+z;
    }
    public static int sum(int num) {
        if(num==1) {
            return 1;
        }else {
            return num+sum(num-1);
        }

    }

    public static void myPrint(int x) {
        if(x==2) {
            return;
        }else {
            System.out.println(x);
        }
    }

    public static int add2(int x, int y) {
        return x+y;
    }

//          mulTable(9);
//        int [] array = {1,3,1,5,5};
//        int i =0;
//        int tmp=0;
//        for( i=0;i<array.length;i++) {
//            tmp ^= array[i];
//        }
//        System.out.println(tmp);
//        Arrays.copyOf()

//        int[] x = new int[3];
//        int[] x =null;
//        int[] tmp=null;
//        x = new int[3];
//        System.out.println(x.length);
//        x[0]=1;
//        x[1]=2;
//        x[2]=3;
//        for (int i = 0; i <x.length ; i++) {
//            System.out.println(x[i]);
//        }
//        tmp =x;
//        tmp[0]=55;
//        System.out.println(x[0]);
//        int line = 10;
//        for(int x=0;x<line;x++) {
//            for (int y = 0; y <line-x ; y++) {
//                System.out.print(" ");
//            }
//            for (int z = 0; z < x; z++) {
//                System.out.print("* ");
//            }
//            System.out.println();
//        }
//        char name = 'A';
//        System.out.println(name);
//        System.out.print(name);
//        System.out.printf(String.valueOf(name));
//        System.out.println("请输入字符：");
//        char x = (char) System.in.read();
//        switch (x) {
//            case 'a' : {
//                System.out.println("我是猪");
//            }
//            case 'b' : {
//                System.out.println("我不是猪");
//            }
//            default: {
//                System.out.println("我真的不是猪");
//            }
//        }

//        int i = 10;
//        while(i<11) {
//            System.out.println("hello bit");
//            i++;
//        }



}