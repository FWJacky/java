package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName TestOutputStream
 * @Description TODO
 * @Author L
 * @Date 2019/5/25 9:53
 * @Version 1.0
 **/
public class TestOutputStream {

    public static void code1() {
        File file = new File("D:" + File.separator + "TestCode" +
                File.separator + "iotest" + File.separator+"test"+File.separator + "hello.text");
        //判断目录是否存在
        File parent = file.getParentFile();
        if(!parent.exists()) {
            parent.mkdirs();
        }

        FileOutputStream outputStream = null;
        try {
//            outputStream = new FileOutputStream(file);
            outputStream = new FileOutputStream(file,true);
            outputStream.write(65);// A
//            String str = "helloworld";
            String str = "I老虎U!！";
            byte[] bytes = str.getBytes();
            outputStream.write(bytes);
            outputStream.write('\n');
            outputStream.write(49);// 1
            outputStream.write(50);// 2
            outputStream.write(97);// a
            outputStream.write(bytes,1,3);//中文不能使用这种方法，会造成乱码
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    //close()必须在finally中
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        File file = new File("D:" + File.separator + "TestCode" +
                File.separator + "iotest" + File.separator+"test"+File.separator + "hello.text");
        //判断目录是否存在
        File parent = file.getParentFile();
        if(!parent.exists()) {
            parent.mkdirs();
        }

        try (FileOutputStream outputStream = new FileOutputStream(file,true)){
            outputStream.write(65);// A
//            String str = "helloworld";
            String str = "I老虎U!！";
            byte[] bytes = str.getBytes();
            outputStream.write(bytes);
            outputStream.write('\n');
            outputStream.write(49);// 1
            outputStream.write(50);// 2
            outputStream.write(97);// a
            outputStream.write(bytes,1,3);//中文不能使用这种方法，会造成乱码
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
