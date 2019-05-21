package io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @ClassName TestFIle
 * @Description TODO
 * @Author L
 * @Date 2019/5/21 19:50
 * @Version 1.0
 **/
public class TestFIle {

    public static void space(int len) {
        for (int i = 0; i < len; i++) {
            System.out.println(" ");
        }
    }

    public static void listAllFiles(File file) {
        if(file.isDirectory()) {
            System.out.println(file);
            File[] files = file.listFiles();
            if(files != null) {
                for (File file1 : files) {
                    listAllFiles(file1);
                }
            }
        }else {
            System.out.println(file);
        }
    }
    public static void main(String[] args) {
        File file = new File("D:"+File.separator+"TestCode"+File.separator+"iotest");
        listAllFiles(file);
    }

    public static void main5(String[] args) {
        File file = new File("D:"+File.separator+"TestCode"+File.separator+"iotest");
        if(file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                System.out.println(file1);
            }
        }
    }

    public static void main4(String[] args) {
        File file = new File("D:"+File.separator+"TestCode"+File.separator+"iotest"+File.separator+"hello.java");
        if(file.exists()) {
            System.out.println("是否是文件：" + file.isFile());
            System.out.println("是否是目录：" + file.isDirectory());
            System.out.println("文件大小（字节）：" + file.length());
            System.out.println("最后一次修改时间：" + new Date(file.lastModified()));
        }
    }

    public static void main3(String[] args) throws IOException {
        File file = new File("D:"+File.separator+"javaSE"+File.separator+"Filedtest"+File.separator+"hello.java");
        //创建父父目录
        if(!file.getParentFile().exists()) {
            //有多少级父目录就创建多少级
            file.getParentFile().mkdirs();
        }
        if(file.exists()) {
            file.delete();
            System.out.println("文件存在，删除成功");
        }else {
            file.createNewFile();
            System.out.println("文件不存在，创建成功");
        }
    }

    public static void main2(String[] args) throws IOException {
        File file = new File("D:"+File.separator+"TestCode"+File.separator+"iotest"+File.separator+"hello.java");
        boolean effect = file.createNewFile();
        if(effect) {
            System.out.println("文件创建成功");
        }else {
            System.out.println("文件创建失败");
        }
    }

    public static void main1(String[] args) {
        File file= new File("D:"+File.separator+"iotest"+File.separator+"hello.java");
        if(file.exists()) {
            file.delete();
            System.out.println("文件存在，删除成功");
        }else {
            System.out.println("文件不存在");
        }
    }
}

