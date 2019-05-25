package io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName TestEncodingDecoding
 * @Description TODO
 * @Author L
 * @Date 2019/5/25 14:50
 * @Version 1.0
 **/
public class TestEncodingDecoding {

    public static void code1() {
        //打印系统的运行信息
//        System.getProperties().list(System.out);
        //打印用户信息
        String userHome = System.getProperty("user.home");
        System.out.println(userHome);
    }

    public static void main(String[] args) {
        try (OutputStream out = new FileOutputStream(
                "D:" + File.separator + "TestCode" +
                        File.separator + "iotest" + File.separator + "encoding.txt")) {
//            out.write("比特科技".getBytes("ISO8859-1"));//乱码了
            out.write("比特科技".getBytes(StandardCharsets.ISO_8859_1));
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
