package jcf;

import io.Person;

import java.util.*;

/**
 * @ClassName TestHashMap
 * @Description TODO
 * @Author L
 * @Date 2019/5/29 21:13
 * @Version 1.0
 **/
public class TestHashMap {

    public static void code() {
        //        Map<Integer,String> map = new HashMap<>();
//        map.put(1,"Java");
//        map.put(2,"C");
//        map.put(3,"Python");
//        map.put(4,"C++");
//        map.put(5,"C#");
//        map.put(6,"PHP");
//        map.put(7,null);
//        map.put(1,"JavaScript");
//        map.put(null,"SQL");
//        System.out.println(map);
//        System.out.println("集合元素的个数："+map.size());
//        System.out.println("集合元素的所有key："+map.keySet());
//        System.out.println("集合元素的所有values："+map.values());
//        System.out.println("集合是否为空："+map.isEmpty());
//        System.out.println("获得key=null的value："+map.get(null));
//        System.out.println("获得key=4的value："+map.get(4));
//        System.out.println("集合是否包含key=5："+map.containsKey(5));
//        System.out.println("集合是否包含Java："+map.containsValue("PHP"));


        //遍历map的方式：
        //1. 通过key来获取value  key  ->  value
//        for (Integer key : map.keySet()) {
//            System.out.println(key + " = " + map.get(key));
//        }
        //2. 通过value获取key    value  ->  key
//        for (String value : map.values()) {
//            System.out.println(value);
//        }
        //3. 通过entrySet来获得
//        for (Map.Entry<Integer, String> entry :map.entrySet()) {
//            System.out.println(entry);
////            System.out.println(entry.getKey() + " = " + entry.getValue());
//        }

//        Map<Integer,String> map = new HashMap<>();
//        map.put(1,"java");
//        map.put(2,"C++");
//        map.put(3,"C");
//        map.put(4,"Python");
////        map.put(null,"JavaScript");
//        map.put(5,null);
//        map.put(1,"C#");
//        map.put(null,null);
//        System.out.println(map);
////        System.out.println(map.get(2));
////        System.out.println(map.get(9));
//        Set<Integer> set = map.keySet();
//        Iterator<Integer> iterator = set.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

//        HashMap<Integer,String> hashMap = new HashMap<>();
//        hashMap.put(null,null);
//        hashMap.put(1,"Java");
//        hashMap.put(2,"Python");
//        hashMap.put(3,"C++");
//        hashMap.put(1,"JavaScript");
//        hashMap.put(null,"C#");
//        hashMap.put(4,null);
//        System.out.println(hashMap);
//        System.out.println(hashMap.get(1));
//        System.out.println(hashMap.get(null));
//        System.out.println(hashMap.get(3));

//        Map<Integer,String> map = new Hashtable<>();
//        map.put(1,"Java");
//        map.put(2,"JavaScript");
//        map.put(3,"C++");
//        map.put(4,"C");
//        map.put(5,"C#");
        //key和value都不能为空
////        map.put(null,"Python");
////        map.put(6,null);
////        map.put(null,null);
//        map.put(1,"MySQL");
//        System.out.println(map);
    }

    public static void main(String[] args) {

        //排序跟TreeSet是一样的
//        Map<Integer,String> map = new TreeMap<>();
//        map.put(1,"Tom");
//        map.put(0,"Jack");
//        map.put(2,"Alice");
//        System.out.println(map);

//        Date date = new Date();
//        Person person1 = new Person();
//        person1.setName("Tom");
//        person1.setSkills(new String[] {"Java","C++"});
//        person1.setAge(20);
//        person1.setBirthday(date);
//
//        Map<Person,String> map = new HashMap<>();
//        map.put(person1,person1.toString());
//
//        Person person2 = new Person();
//        person2.setName("Tom");
//        person2.setSkills(new String[] {"Java","C++"});
//        person2.setAge(20);
//        person2.setBirthday(date);
//
//        System.out.println(map.containsKey(person2));
//        System.out.println(map.get(person2));

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(1);
        list.add(3);
        list.sort(Integer::compareTo);
        list.sort(((o1, o2) -> -1*o1.compareTo(o2)));
        System.out.println(list);




    }
}
