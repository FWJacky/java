package jcf;

import java.util.Hashtable;

/**
 * @ClassName TestHashTable
 * @Description TODO
 * @Author L
 * @Date 2019/6/1 18:01
 * @Version 1.0
 **/
public class TestHashTable {

    public static void main(String[] args) {
        Hashtable<String,String> hashtable = new Hashtable<>();
        hashtable.put("1","Java");
        //hashtable中key和value都不能为空
        //NullPointerException
        hashtable.put("2",null);
        System.out.println(hashtable);
    }
}
