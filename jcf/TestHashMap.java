package jcf;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TestHashMap
 * @Description TODO
 * @Author L
 * @Date 2019/5/29 21:13
 * @Version 1.0
 **/
public class TestHashMap {

    public static void main(String[] args) {

        Map<Integer,String> map = new HashMap<>();
        map.put(1,"Java");
        map.put(2,"C");
        map.put(3,"Python");
        map.put(4,"C++");
        map.put(5,"C#");
        map.put(6,"PHP");
        map.put(7,null);
        map.put(1,"JavaScript");
        map.put(null,"SQL");
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
        for (Map.Entry<Integer, String> entry :map.entrySet()) {
            System.out.println(entry);
//            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
