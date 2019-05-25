package io;

import java.io.File;
import java.io.FileInputStream;

/**
 * @ClassName TestInputStream
 * @Description TODO
 * @Author L
 * @Date 2019/5/25 11:02
 * @Version 1.0
 **/
public class TestInputStream {

    public static void main(String[] args) {
        File file = new File("D:" + File.separator + "TestCode" + File.separator
                + "iotest" + File.separator + "test" + File.separator + "hello.text");
        try (FileInputStream inputStream = new FileInputStream(file)) {
            //读取方法1：
//            int value = -1;
//            while ((value = inputStream.read()) != -1) {
//                System.out.println(value);
//            }

            //读取方法2：
//            byte[] buff = new byte[5];
//            int len = -1;
//            while ((len = inputStream.read(buff)) != -1) {
//                System.out.print(new String(buff,0,len));
//            }

            //读取方法3：
            byte[] buff = new byte[5];
            int len = inputStream.read(buff,2,2);
            System.out.println(new String(buff,0,len));
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
