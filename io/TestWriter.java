package io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @ClassName TestWriter
 * @Description TODO
 * @Author L
 * @Date 2019/5/25 11:22
 * @Version 1.0
 **/
public class TestWriter {

    public static void code1() {
        File file = new File("D:" + File.separator + "TestCode" +
                File.separator + "iotest" + File.separator + "test" + File.separator + "writer.text");

        File parent = file.getParentFile();
        if (!parent.exists()) {
            boolean effect = parent.mkdirs();
            if (!effect) {
                throw new RuntimeException("create directory " + parent.getAbsolutePath() + "failed");
            }
        }
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.append('A').append("Hello World").append('\n');
            fileWriter.write("I老虎U!！");
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File file = new File("D:" + File.separator + "TestCode" +
                File.separator + "iotest" + File.separator + "test" + File.separator + "writer.text");

        File parent = file.getParentFile();
        if (!parent.exists()) {
            boolean effect = parent.mkdirs();
            if (!effect) {
                throw new RuntimeException("create directory " + parent.getAbsolutePath() + "failed");
            }
        }
        try (FileReader fileReader = new FileReader(file)) {
            /*char[] buff = new char[1024];
            int len = fileReader.read(buff);
            System.out.println("读了：" + len + "个字符");
            System.out.println(new String(buff));
            */

            char[] buff = new char[5];
            int len = -1;
            while ((len = fileReader.read(buff)) != -1) {
                System.out.print(new String(buff));
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
