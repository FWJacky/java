package jcf;

import io.Person;

import java.util.*;

/**
 * @ClassName TestLinkedList
 * @Description TODO
 * @Author L
 * @Date 2019/5/29 18:51
 * @Version 1.0
 **/
public class TestLinkedList {

    public static void code1() {
        List<String> list = new LinkedList<>();
        list.add("Java");
        list.add(0,"PHP");
        list.add("C#");
        list.add("JavaScript");
        list.remove("C#");
        System.out.println(list);
    }

    //HashSet  不可排序
    public static void code2(){
        Set<String> set = new HashSet<>();
        set.add("Java");
        set.add("PHP");
        set.add("C++");
        set.add("C#");
        set.add("SQL");
        set.add("C");
        set.add("Python");
        set.add("PHP");  //8个   重复1个   7个不重复
        System.out.println("集合元素个数："+set.size());
        System.out.println("集合是否为空："+set.isEmpty());
        System.out.println("集合元素："+set);
        System.out.println("移除SQL："+set.remove("SQL"));
        System.out.println("是否包含Java："+set.contains("Java"));
    }

    //TreeSet 可排序   按照字母表顺序排序
    public static void code3(){
        Set<String> set = new TreeSet<>();
        set.add("Java");
        set.add("PHP");
        set.add("C++");
        set.add("C#");
        set.add("SQL");
        set.add("C");
        set.add("Python");
        set.add("PHP");  //8个   重复1个   7个不重复
        System.out.println(set);
    }


    public static void main(String[] args) {
//        Set<Integer> set = new TreeSet<>();
//        set.add(50);
//        set.add(25);
//        set.add(30);
//        set.add(18);
        //升序排序

        //1. JDK中定义的类的实例化对象在TreeSet  如何改变？
        //2. TreeSet中使用
        //实现Comparable接口
        //如果在new TreeSet()时，指定了比较策略，那么在Person类中的比较方法就失效了

//        Set<Person> set = new TreeSet<>(new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return Integer.compare(o1.getName().length(),o2.getName().length());
//            }
//        });
        Set<Person> set = new TreeSet<>(Comparator.comparingInt(o -> o.getName().length()));
        set.add(new Person("Jack",22));
        set.add(new Person("Tom",21));
        set.add(new Person("Alice",20));
        set.add(new Person("张三",24));
        System.out.println(set);

    }
}
