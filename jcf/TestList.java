package jcf;

import io.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @ClassName TestList
 * @Description TODO
 * @Author L
 * @Date 2019/5/28 20:59
 * @Version 1.0
 **/
public class TestList {

    public static void code1(){
        //        List<String> list = new ArrayList<>();
        Collection<String> list = new ArrayList<>();
        list.add("java");
//        list.add(0,"C++");
        list.add("PHP");
        list.add("PHP");
//        System.out.println(list);
//        System.out.println(list.get(3));
//        System.out.println(list.get(4));
//        System.out.println("元素列表："+list);
//        System.out.println("集合长度："+list.size());
//        System.out.println("集合是否为空："+list.isEmpty());
//        System.out.println("集合是否包含PHP："+list.contains("PHP"));
//        System.out.println("集合是否包含CSS："+list.contains("CSS"));
//        System.out.println("移除集合中的PHP："+list.remove("PHP"));
//        System.out.println(list);

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }

//        for (String item: list) {
//            System.out.println(item);
//        }
        Object[] objects = list.toArray();
        for (Object object:objects) {
            System.out.println(object);
        }
        System.out.println(objects);
        System.out.println(Arrays.toString(objects));
    }

    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setName("Jack");
        Person person2 = new Person();
        person2.setName("Tom");
        List<Person> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);
        System.out.println(list);

        Person person3 = new Person();
        person3.setName("Tom");

        //Object类的默认equals()
        System.out.println("是否包含person3："+list.contains(person3));
        System.out.println("是否包含person2："+list.contains(person2));
    }
}
