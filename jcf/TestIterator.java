package jcf;

import java.util.*;

/**
 * @ClassName TestIterator
 * @Description TODO
 * @Author L
 * @Date 2019/5/29 20:44
 * @Version 1.0
 **/
public class TestIterator {

    public static void code1(){
        //        List<String> list = new ArrayList<>();
        Set<String> list = new HashSet<>();
        list.add("Java");
        list.add("C++");
        list.add("PHP");
        System.out.println(list);

//        Iterator<String> iterator = list.iterator();
//        while(iterator.hasNext()) {
//            String element = iterator.next();
////            System.out.println(element);
//            //迭代器在remove时，必须要有next
//            //否则迭代器无法remove掉任何元素，并且会出现异常java.lang.IllegalStateException
//            iterator.remove();
//        }
//        System.out.println(list);

        //多线程不安全   在遍历字符串时不能进行remove操作
        //异常：java.util.ConcurrentModificationException
//        for (String str: list) {
//            list.remove(str);
//        }
    }

    public static void main(String[] args) {





    }
}
