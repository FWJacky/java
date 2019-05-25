package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName TestMerge
 * @Description TODO
 * @Author L
 * @Date 2019/5/25 17:19
 * @Version 1.0
 **/
public class TestMerge {

    public static void merge(String[] srcFiles, String destFilePath) {
        if (srcFiles == null) {
            throw new IllegalArgumentException(srcFiles + " must be not null");
        }
        if (destFilePath == null && destFilePath.isEmpty()) {
            throw new IllegalArgumentException(destFilePath + " must be not null");
        }
        File destFile = new File(destFilePath);
        File parent = destFile.getParentFile();
        if (!parent.exists()) {
            boolean effect = parent.mkdirs();
            if (!effect) {
                throw new IllegalArgumentException(parent + " create failed");
            }
        }
        for (String src : srcFiles) {
            File srcFile = new File(src);
            try (FileInputStream in = new FileInputStream(srcFile);
                 FileOutputStream out = new FileOutputStream(destFile, true)) {
                byte[] buff = new byte[1024];
                int len = -1;
                while ((len = in.read(buff)) != -1) {
                    out.write(buff, 0, len);
                }
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String[] srcFiles = {"D:" + File.separator + "TestCode" + File.separator + "iotest" + File.separator + "data-a.txt",
                "D:" + File.separator + "TestCode" + File.separator + "iotest" + File.separator + "data-b.txt",
                "D:" + File.separator + "TestCode" + File.separator + "iotest" + File.separator + "data-c.txt"};
        String destFilePath = "D:" + File.separator + "TestCode" + File.separator + "iotest" + File.separator + "data.txt";
        merge(srcFiles, destFilePath);
    }
}
