package jcf;

import java.util.*;

/**
 * @ClassName TestCollection
 * @Description TODO
 * @Author L
 * @Date 2019/6/1 18:04
 * @Version 1.0
 **/
public class TestCollections {

    public static void code() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Java", "C++", "PHP");
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
    }

    public static void code2() {
        //当利用Collections的emptyList()方法返回一个空列表时
        //不能向列表中添加元素，否则会抛出异常UnsupportedOperationException
        List list = Collections.emptyList();
//        list.add("java");
        System.out.println(list.isEmpty());//true
    }

    public static void code3() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            list.add(random.nextInt(100));//[0,100)
        }
        System.out.println(list);
        Integer max = Collections.max(list);
        System.out.println(max);
    }

    public static void code4() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 55; i++) {
            list.add(i);
        }
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
    }

    public static void code5() {
        //当Collections的singleTonList()方法返回一个不可表列表时，不能向列表中添加元素
        //UnsupportedOperationException
        List list = Collections.singletonList("java");
//        list.add("PHP");
        System.out.println(list);

//        Map<Integer,String> map = Collections.singletonMap(1,"666");
//        System.out.println(map);
    }


    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "666");
        map.put(2, "777");
        map.put(3, "888");
        map.put(4, "999");
        Set<Map.Entry<Integer, String>> set = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = set.iterator();
        while (iterator.hasNext()) {
            //            System.out.println(iterator.next());
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

    }
}
