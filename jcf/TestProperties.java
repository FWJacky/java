package jcf;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

/**
 * @ClassName TestProperties
 * @Description TODO
 * @Author L
 * @Date 2019/6/1 19:53
 * @Version 1.0
 **/
public class TestProperties {


    public static void code() {
        Properties properties = new Properties();
        properties.setProperty("Java", "Java is the best");
        properties.setProperty("C++", "is too");
        System.out.println(properties.getProperty("C++"));
        System.out.println(properties.getProperty("php"));
        System.out.println(properties.getProperty("php", "is a good language"));
    }

    public static void code2() {
        File file = new File("D:\\TestCode\\20190521\\src\\jcf\\hello.properties");

        //读取file里面的内容
        //1. FileReader
//        try(FileReader fileReader = new FileReader(file)){
//            int str = 0;
////            StandardCharsets.UTF_8;
//            char[] buff = new char[1024];
//            while((str = fileReader.read(buff))!=-1 ) {
//                System.out.println(buff);
//            }
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Java I 老虎 U!！");
//
//        //2. BufferedReader
//        try(Reader reader = new FileReader(file);
//        BufferedReader bufferedReader = new BufferedReader(reader)){
//            String str = null;
//            while((str=bufferedReader.readLine())!=null) {
//                System.out.println(str);
//            }
//        }catch (IOException e) {
//            e.printStackTrace();
//        }

        //3.Scanner
//        try(Scanner scanner = new Scanner(file)) {
//            while (scanner.hasNext()) {
//                System.out.println(scanner.next());
//            }
//        }catch (IOException e) {
//            e.printStackTrace();
//        }

        //4.FileInputStream
        try(FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] buff = new byte[1024];
            int len = -1;
            while((len=fileInputStream.read(buff))!=-1) {
                //byte数组输出为字符串要用new String(byte[])
                System.out.println(new String(buff));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

//        Properties properties = new Properties();
//        try(FileReader reader = new FileReader(file)) {
//            properties.load(reader);
////            for (Map.Entry<Object,Object> entry : properties.entrySet()) {
////                System.out.println(entry.getKey() + " = " + entry.getValue());
////            }
//            //输出到屏幕
////            properties.list(System.out);
//
//            //没有调用store方法的话，信息就不会保存到属性文件中
//            System.out.println(properties.getProperty("java"));
//            System.out.println(properties.getProperty("php","also too!"));
////
////            //set
//            properties.setProperty("python","程序员好帮手");
//            try(FileWriter writer = new FileWriter(file)) {
//                properties.store(writer,"Add properties");
//            }
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
    }


    public static void main(String[] args) {
       Properties properties = new Properties();
       try(InputStream in = TestProperties.class.getClassLoader().getResourceAsStream("jcf/hello.properties")){
           properties.load(in);
           properties.list(System.out);
       }catch (IOException e) {
           e.printStackTrace();
       }



    }
}
