package io;

import java.io.*;

/**
 * @ClassName TestByteOutputStream
 * @Description TODO 通过内存流将iotest目录下的data-a.txt,data-b.txt,data-c.txt复制到a目录下相对应的文件中
 * @Author L
 * @Date 2019/5/26 23:38
 * @Version 1.0
 **/
public class TestByteOutputStream {


    public static void main(String[] args) {
        String directory = "D:" + File.separator + "TestCode" + File.separator + "iotest" + File.separator;
        try (FileInputStream f1 = new FileInputStream(new File(directory + "data-a.txt"));
             FileInputStream f2 = new FileInputStream(new File(directory + "data-b.txt"));
             FileInputStream f3 = new FileInputStream(new File(directory + "data-c.txt"));
             ByteArrayOutputStream out1 = new ByteArrayOutputStream()){
            // ByteArrayOutputStream out2 = new ByteArrayOutputStream();
             //ByteArrayOutputStream out3 = new ByteArrayOutputStream()) {
            byte[] buff = new byte[1024];
            FileOutputStream file1 = new FileOutputStream(directory + "a" +File.separator+ "data-a.txt");
            FileOutputStream file2 = new FileOutputStream(directory + "a" +File.separator+ "data-b.txt");
            FileOutputStream file3 = new FileOutputStream(directory + "a" +File.separator+ "data-c.txt");
            int len1= -1;
            int data1 = 0;
            int data2 = 0;
            int data3 = 0;
            while ((len1 = f1.read(buff)) != -1) {
                data1 = len1;
                out1.write(buff, 0, len1);
            }
            file1.write(out1.toByteArray(),0,data1);
            file1.flush();

            int len2 = -1;
            while ((len2 = f2.read(buff)) != -1) {
                data2 = len2;
                out1.write(buff,0, len2);
            }
            file2.write(out1.toByteArray(),data1,data2);
            file2.flush();

            int len3 =-1;
            while ((len3 = f3.read(buff)) != -1) {
                data3 = len3;
                out1.write(buff, 0, len3);
            }
            file3.write(out1.toByteArray(),data1+data2,data3);
            file3.flush();
//            FileOutputStream outputStream = new FileOutputStream(new File(directory + "a" + File.separator + "outFile.txt"));
//            outputStream.write(out.toByteArray());
//            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
