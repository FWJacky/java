package com.github.dailyTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName FailFastTest
 * @Description TODO
 * @Author L
 * @Date 2019/7/8 21:14
 * @Version 1.0
 **/
public class FailFastTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // modCount = 1
        list.add("hello");
        // modCount = 2
        list.add("bit");
        // modCount = 3
        list.add("hello");
        // modCount = 4
        list.add("Java");
        //标准的遍历方式是迭代器模式
        // expectModCount = modCount = 4
        Iterator<String> iterator = list.listIterator();
        while(iterator.hasNext()) {
            String str = iterator.next();
            if(str.equals("bit")) {
                // 修改了list结构
                // modCount = 5;
                list.remove("bit");
            }
        }
    }
}
