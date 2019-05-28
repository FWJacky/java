package io;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName TestSplit
 * @Description TODO
 * @Author L
 * @Date 2019/5/27 15:50
 * @Version 1.0
 **/
public class TestSplit {

    public static void splitFile(String srcFile, String[] destFiles) {
        String directory = "D:" + File.separator + "TestCode" + File.separator + "iotest" + File.separator;
        try (FileInputStream srcFile1 = new FileInputStream(directory + "reflex3.png");
             FileOutputStream destFile1 = new FileOutputStream(directory + "picture1.png");
             FileOutputStream destFile2 = new FileOutputStream(directory + "picture2.png");
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            int len = -1;
            byte[] buff = new byte[1024];
//            while ((int))
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //目的是将reflex.png  ->  reflex1.png reflex2.png
    //首先传入reflex.png文件
    public static void main(String[] args) throws IOException {
        String directory = "D:" + File.separator + "TestCode" + File.separator + "iotest" + File.separator;
        File srcFile = new File(directory + "reflex3.png");
        File destFile1 = new File(directory + "picture1.png");
        File destFile2 = new File(directory + "picture2.png");
        long len = srcFile.length();
        //这里的字节数要看文件实际占用空间大小，windows对于KB的处理会采用四舍五入
        long size1 = 19268;
        long size2 = 62110;
        //设置文件指针偏移，从该文件的开头测量，发生下一次读取或写入。即第二个文件写入的开始点
        long pos = size1;
        //将源文件写入内存
        RandomAccessFile rf = new RandomAccessFile(srcFile, "rw");
        //创建导出文件
        File[] files = new File[2];
        files = new File[]{destFile1, destFile2};
        //循环读取文件内容
        for (int i = 0; i <= 1; i++) {
            //缓冲输出流，创建一个新的缓冲输出流，以将数据写入指定的底层输出流。
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(files[i]));
            byte[] bs;
            //第一个文件读取的字节大小
            if (i == 0) {
                bs = new byte[(int) size1];
                rf.read(bs);
            } else {
                //第二个文件读取的字节大小
                rf.seek(pos);
                bs = new byte[(int) size2];
                rf.read(bs);
            }
            out.write(bs);
            out.flush();
            out.close();
        }
    }
}



