package io;

import java.io.*;

/**
 * @ClassName TestMemoryStream
 * @Description TODO
 * @Author L
 * @Date 2019/5/25 15:08
 * @Version 1.0
 **/
public class TestMemoryStream {

    public static void code1() {
        String content = "hello world";
        //要求：内存流 hello world => HELLO WORLD
        byte[] data = content.getBytes();
        //input -> convert -> output
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int b = -1;
        //read() 读取单个字节的内容
        //这里的b中是读取的byte单个字节所对应的ASCII值
        while((b = in.read()) != -1) {
            out.write(Character.toUpperCase(b));
        }
            System.out.println(out);
        try {
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void code2(){
        String directory = "D:" + File.separator + "TestCode" + File.separator + "iotest" + File.separator;
        try(FileInputStream fa = new FileInputStream(directory+"data-a.txt");
            FileInputStream fb = new FileInputStream(directory+"data-b.txt");
            FileInputStream fc = new FileInputStream(directory+"data-c.txt");
            FileOutputStream fdata = new FileOutputStream(directory+"data1.txt");

            ByteArrayOutputStream memoryout = new ByteArrayOutputStream()) {
            byte[] buff = new byte[1024];
            int len = -1;
            while((len = fa.read(buff)) != -1) {
                memoryout.write(buff,0,len);
            }
            while((len = fb.read(buff))!=-1) {
                memoryout.write(buff,0,len);
            }
            while((len = fc.read(buff))!=-1) {
                memoryout.write(buff,0,len);
            }
            fdata.write(memoryout.toByteArray());
            fdata.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //要求：
        // data-a.txt + data-b.txt => data.txt
        //实现方式
        //1. data-a.txt -> data.txt -> data-b.txt -> append data.txt  => 练习

        //2. data-a.txt -> FileInputStream()
        //   data-b.txt -> FileInputStream()
        //   data-c.txt -> FileInputStream()
        //   data.txt   -> FileOutputStream()
        //   三个输入流通过ByteArrayOutStream内存流进行合并处理
        //   再将结果输出给data.txt

        /*
         * @Author L
         * @Description //TODO   这和字节流、字符流操作有什么区别  利用内存流还是需要通过文件来接收合并后的内容，而字节流、字符流直接可以合并到文件中，不需要再取接收合并后的内容？？？
         * @Date 0:40 2019/5/27
         * @Param [args]
         * @return void
         **/
        String directory = "D:" + File.separator + "TestCode" + File.separator + "iotest" + File.separator;
        try(FileOutputStream f = new FileOutputStream(directory+"reflex3.png");
            FileInputStream f1 = new FileInputStream(directory+"reflex1.png");
            FileInputStream f2 = new FileInputStream(directory+"reflex2.png");
            ByteArrayOutputStream memoryout = new ByteArrayOutputStream()) {
            byte[] buff = new byte[1024];
            int len = -1;
            while((len = f1.read(buff)) != -1) {
                memoryout.write(buff,0,len);
            }
            while((len = f2.read(buff))!=-1) {
                memoryout.write(buff,0,len);
            }
            f.write(memoryout.toByteArray());
            f.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
