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
    public static void main(String[] args) {
        String directory = "D:" + File.separator + "TestCode" + File.separator + "iotest" + File.separator;
        try (InputStream srcFile1 = new FileInputStream(directory + "reflex3.png");
             FileOutputStream destFile1 = new FileOutputStream(directory + "picture1.png");
             FileOutputStream destFile2 = new FileOutputStream(directory + "picture2.png");
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(srcFile1))) {
            Scanner sr = new Scanner(srcFile1);
            int lineNum = 0;
            while(sr.hasNextLine()) {
                lineNum++;
                sr.nextLine();
            }
//            System.out.println(lineNum);
            String str = "";
            int count =0;
            while((str = bufferedReader.readLine())!=null) {
                count ++;
                if(count<=183){
                    destFile1.write(str.getBytes());
                }
            }
            destFile1.flush();
            while((str = bufferedReader.readLine())!=null) {
                count++;
                if(count>183) {
                    destFile2.write(str.getBytes());
                }
            }
            destFile2.flush();
            bufferedReader.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
