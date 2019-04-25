import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @ClassName Test
 * @Description TODO
 * @Author L
 * @Date 2019/4/15 15:14
 * @Version 1.0
 **/

//class Person {
//        public void print() {
//            System.out.println("1.[Person]类的print方法");
//        }
//}
//class Student extends Person {
//    public void print() {
//        System.out.println("2.[Student]类的print方法");
//    }
//    public void fun() {
//        System.out.println("只有我有");
//    }
//}
//}
//    class A {
//        private String name;
//        public A(String name) {
//            this.name = name;
//        }
//        class B {
//           final static int age = 20;
//        }
//}
//   final class Person {
//        public String info = "Person";
//        int age = 10;
//    }
//    class Student extends Person {
//        public String info = "Student";
//    }

    class Person {
    private String name;
    private int age;
    public Person(String name,int age) {
        this.age = age;
        this.name = name;
    }
    public String toString() {
        return "姓名："+this.name+",年龄："+this.age;
    }
}
public class Test {
        public static void fun(Object object) {
            System.out.println(object.toString());
        }
    public static void main(String[] args) {
        fun(new Person("yuisama",25));
        fun("hello");
    }
    public static String firstUpper(String str) {
        if("".equals(str)||str == null) {
            return str;
        }
        if(str.length()>1) {
            return str.substring(0,1).toUpperCase() + str.substring(1);
        }
        return str.toUpperCase();
    }
    public static void main8(String[] args) {
        String str = "hello";

        System.out.println(firstUpper("yuisama"));
        System.out.println(firstUpper(""));
        System.out.println(firstUpper("a"));
    }

    public static void main7(String[] args) {
        String str = "heelo";
        String str2 = "hello";
        System.out.println(str.compareTo(str2));
    }
    public static void main6(String[] args) {

        String str = "helloworld";
        char[] data = str.toCharArray();
        for(int i = 0 ; i<data.length;i++) {
            data[i] -=32;
            System.out.println(data[i]+"、");
        }
        System.out.println(new String(data));
        System.out.println(new String(data,5,5)); //字符数组部分转换为字符串
    }

    public static void main5(String[] args) {
        String str = "hello";
        System.out.println(str.hashCode());
        str = str + "world";
        System.out.println(str.hashCode());
        str += "!!!";
        System.out.println(str.hashCode());
    }
    public static void main4(String[] args) {
        String str = "hello";
        String str2 = new String("hello");
        String str3 = new String("hello").intern();
        String st4 = null;
        System.out.println("hello".equals(st4));
        System.out.println(st4.equals("hello"));
        System.out.println(str==str2);
        System.out.println(str2 == str3);
        System.out.println(str == str3);
        System.out.println("hello".equals(str2));
    }
    public static void main3(String[] args) {
        double b1=1,b2=2,b3,b6,b8;
        final double b4=4,b5=6,b7=9;
        b3 = (b1+b2);
        b6 = b4 + b5;
        b8 = (b1+b4);
//        b7 = (b2+b5);
        System.out.println(b3+b6);
    }

    public static void main2(String[] args) {
//        Person p = new Student();
//        p.print();
//        if(p instanceof Student) {
//
//        }
//        Student s = new Student();
//        s.fun();
//        final int age;
//        age = 10;
//        System.out.println(age);
//        System.out.println(new Student().info);
    }

    public static void main1(String[] args) {
//        Person p = new Student();
//        p.print();
//        new Student().print();
//        String str = new String("hello");
//        String str2 = new String("hello");
//        String str3 = new String("hell");
////        System.out.println(str == str2);
////        System.out.println(str.equals(str2));
//        System.out.println(str.hashCode());
//        System.out.println(str2.hashCode());
//        System.out.println(str3.hashCode());
//        int a = 3;
//        int b = 3;
//        System.out.println(Integer.hashCode(a));
//        System.out.println(Integer.hashCode(b));
    }


}
