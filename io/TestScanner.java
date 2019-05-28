package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * @ClassName TestScanner
 * @Description TODO
 * @Author L
 * @Date 2019/5/28 19:10
 * @Version 1.0
 **/
public class TestScanner {

    public static void code1() {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("从键盘读取数据：");
//        if(scanner.hasNext()) {  // 有输⼊内容,不判断空字符串
//            System.out.println(scanner.next());
//        }

//        System.out.println("请输入年龄：");
//        if(scanner.hasNextInt()) {
//            System.out.println(scanner.nextInt());
//        }else {
//            System.out.println("输入的格式不对！");
//        }

        System.out.println("请输入生日：");
        //生日的格式是：
        //2019-05-25
        //4-2-2
        //正则表达式：
        //\d ->  表示0-9的数字
        //{4} ->  出现的次数
        if(scanner.hasNext("\\d{4}-\\d{2}-\\d{2}")) {
            System.out.println(scanner.next());
        }else{
            System.out.println("生日格式不正确！");
        }
        scanner.close();
    }

    public static void main(String[] args) {
        String directory = "D:" + File.separator + "TestCode" + File.separator + "iotest" + File.separator;
       try {
           Scanner scanner = new Scanner(new File(directory + "data.txt"));
           scanner.useDelimiter("\n");
           while(scanner.hasNext()) {
               System.out.println(scanner.next());
           }
           scanner.close();
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }
    }
}
