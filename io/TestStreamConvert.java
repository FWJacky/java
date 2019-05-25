package io;

import java.io.*;

/**
 * @ClassName TestStreamConvert
 * @Description TODO
 * @Author L
 * @Date 2019/5/25 11:48
 * @Version 1.0
 **/
public class TestStreamConvert {

    public static void main(String[] args) {
        File file = new File("D:" + File.separator + "TestCode" +
                File.separator + "iotest" + File.separator + "test" + File.separator + "writer.text");
        //字节流
        //InputStream -> FileInputStream
        try (InputStream inputStream = new FileInputStream(file);
             Reader reader = new InputStreamReader(inputStream)) {
            char[] buff = new char[1024];
            int len = -1;
            while ((len = reader.read(buff)) != -1) {
                System.out.println(new String(buff, 0, len));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
