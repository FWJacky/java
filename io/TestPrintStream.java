package io;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName TestPrint
 * @Description TODO
 * @Author L
 * @Date 2019/5/25 23:49
 * @Version 1.0
 **/
public class TestPrintStream {

    public static void main(String[] args) {
        File file = new File("D:" + File.separator + "TestCode" + File.separator
        + "iotest" + File.separator + "printstream.txt");
        try(PrintWriter printWriter = new PrintWriter(new FileOutputStream(file))){
//            printWriter.print("姓名：");
//            printWriter.println("张三");
//            printWriter.print("年龄：");
//            printWriter.println(18);
            printWriter.printf("姓名：%s 年龄：%d\n","张三",18);
            printWriter.printf("姓名：%s 年龄：%d","张三",18);
            printWriter.format("姓名：%s 年龄：%d","张三",18);
            printWriter.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
