package io;

import java.io.*;

/**
 * @ClassName TestBufferedReader
 * @Description TODO
 * @Author L
 * @Date 2019/5/28 18:51
 * @Version 1.0
 **/
public class TestBufferedReader {

    public static void code1() {
        //        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("请输入信息：");
//        try {
//            String str = bufferedReader.readLine();
//            System.out.println("输入信息为："+str);
//            bufferedReader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //读取键盘输入的信息
        try (BufferedReader buff = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("请输入信息：");
            String str = buff.readLine();//默认回车键结束输入
            System.out.println("输入信息为：" + str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String directory = "D:" + File.separator + "TestCode" + File.separator + "iotest" + File.separator;
        try (BufferedReader buff = new BufferedReader(new FileReader(directory + "data.txt"))) {
            String str = null;
            while ((str = buff.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
