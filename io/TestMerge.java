package io;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

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
            int length = (int) srcFile.length();
//            System.out.println(length);
//            System.out.println(Arrays.toString(trans(length)));
            try (FileInputStream in = new FileInputStream(srcFile);
                 FileOutputStream out = new FileOutputStream(destFile, true)) {
                //文件长度字节得加在两个文件中间，不然合并后的图片将无法显示
                //length -> byte[]   82(int) -> 32(bit)
                for (int i = 0; i < trans(length).length; i++) {
//                    System.out.println(trans(length)[i]);
                    out.write(trans(length)[i]);
                }
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

    public static byte[] trans(int data) {
        //int转换成byte[] 不需要 & 0xFF
        //0xFF是字面量：00000000 00000000 00000000 11111111
        byte[] ret = new byte[4];
        ret[0] = (byte) (data >> 24);
        ret[1] = (byte) (data >> 16);
        ret[2] = (byte) (data >> 8);
        ret[3] = (byte) data;
        return ret;
    }

    public static int byteArrayToInt(byte[] buff) {
        //byte[] 转换成int 必须 & 0xFF
        int values = 0;
        for (int i = 0; i < 4; i++) {
            int shift = (3 - i) * 8;
            values += (buff[i] & 0xFF) << shift;
        }
        return values;
    }

    public static void main(String[] args) {
//        String[] srcFiles = {"D:" + File.separator + "TestCode" + File.separator + "iotest" + File.separator + "data-a.txt",
//                "D:" + File.separator + "TestCode" + File.separator + "iotest" + File.separator + "data-b.txt",
//                "D:" + File.separator + "TestCode" + File.separator + "iotest" + File.separator + "data-c.txt"};
//        String destFilePath = "D:" + File.separator + "TestCode" + File.separator + "iotest" + File.separator + "data.txt";
//        merge(srcFiles, destFilePath);

        String[] srcFiles = {"D:" + File.separator + "TestCode" + File.separator + "iotest" + File.separator + "reflex1.png",
                "D:" + File.separator + "TestCode" + File.separator + "iotest" + File.separator + "reflex2.png"};
        String destFilePath = "D:" + File.separator + "TestCode" + File.separator + "iotest"+File.separator+"reflex.png";
        merge(srcFiles,destFilePath);

    }
}
