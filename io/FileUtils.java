package io;

import java.io.*;

/**
 * @ClassName FileUtils
 * @Description TODO
 * @Author L
 * @Date 2019/5/25 11:59
 * @Version 1.0
 **/
public class FileUtils {

    //example:
    //d:\TestCode\iotest\test\writer.text -> d:TextCode\iotest\com\writer.text
    public static void copyFile(String srcFilePath,String destFilePath) {
        //1. String path -> file
        if(srcFilePath == null && srcFilePath.isEmpty()) {
            throw new IllegalArgumentException(srcFilePath + "must be not null/empty");
        }
        File srcFile = new File(srcFilePath);
        if(destFilePath == null && destFilePath.isEmpty()) {
            throw new IllegalArgumentException(destFilePath + "must be not null/empty");
        }
        File destFile = new File(destFilePath);
        //2. 校验
        //srcFile必须存在
        //destFile目录必须存在，不存在创建
        if(!srcFile.exists()) {
            throw new IllegalArgumentException(srcFile + "must be not null/empty");
        }
        File destParent = destFile.getParentFile();
        if(!destParent.exists()) {
            boolean effect = destParent.mkdirs();
            if(!effect) {
                System.out.println("创建失败");
            }
        }
        //3. 文件读取和写入
        //srcFile -> 输入流
        try (InputStream in = new FileInputStream(srcFile);
        OutputStream out = new FileOutputStream(destFile)) {
            byte[] buff = new byte[1024];
            int len = -1;
            while((len = in.read(buff))!=-1) {
                out.write(buff,0,len);
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String srcFile="d:"+File.separator+
                "TestCode"+File.separator+"iotest"+File.separator+"test"+File.separator+"writer.text";
        String destFile= "d:"+File.separator+
                "TestCode"+File.separator+"iotest"+File.separator+"a"+File.separator+"writer.text";
        copyFile(srcFile,destFile);
    }
}
