package io;

import java.io.*;

/**
 * @ClassName TestCopy
 * @Description TODO
 * @Author L
 * @Date 2019/5/25 17:00
 * @Version 1.0
 **/
public class TestCopy {

    public static void copy(String srcFilePath, String destFilePath) {
        if(srcFilePath == null &&  srcFilePath.isEmpty()) {
            throw new IllegalArgumentException(srcFilePath + " must not be null/empty");
        }
        File srcFile = new File(srcFilePath);
        if(destFilePath == null && destFilePath.isEmpty()) {
            throw new IllegalArgumentException(destFilePath + " must not be null/empty");
        }
        //如果目标路径中的文件夹不存在，则在后面加上源路径需要拷贝的文件名
        File destFile = new File(destFilePath,srcFile.getName());

        if(!srcFile.exists()) {
            throw new IllegalArgumentException(srcFile + " must be not empty");
        }
        File destParent = destFile.getParentFile();
        if(!destParent.exists()) {
            boolean effect = destParent.mkdirs();
            if(!effect) {
                throw new IllegalArgumentException(destParent + "create failed");
            }
        }

        try (InputStream in = new FileInputStream(srcFile);
             OutputStream out = new FileOutputStream(destFile)){
            byte[] buff = new byte[5];
            int len = -1;
            while((len = in.read(buff))!=-1) {
                out.write(buff,0,len);
            }
            out.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String srcFilePath = "D:" + File.separator + "TestCode" + File.separator +
                "iotest" + File.separator +"test"+File.separator+ "writer.text";
        String destFilePath = "D:" + File.separator + "TestCode" + File.separator +
                "iotest"+File.separator+"b" ;
        copy(srcFilePath,destFilePath);
    }
}
