package com.github.FWJacky.classLoader;

import com.github.FWJacky.classLoader.Member;
import java.io.*;

/**
 * @ClassName MyClassLoader
 * @Description TODO
 * @Author L
 * @Date 2019/5/21 15:25
 * @Version 1.0
 **/

    //D:\IDEjava代码\20190518\src\com\github\FWJacky\classLoader\Member.java
class MyclassLoader extends java.lang.ClassLoader {

    public Class loadClasses(String className) throws IOException {
        //加载类文件的信息
        byte[] byteCodeData = loadData(className);
        //将字节数组转换为类别Class的实例
        return super.defineClass(className,byteCodeData,0,byteCodeData.length);
    }

    private byte[] loadData(String className) throws FileNotFoundException {
        //classpath:D:\TestCode\20190518\src\com\github\FWJacky\classLoader\Member.java
        String classpath = "D:\\TestCode\\20190518\\src\\";
        String classField = classpath + className.replace(".","\\\\") + ".class";
        //取得所有字节内容，放在内存中
       try (FileInputStream in = new FileInputStream(classField);
            ByteArrayOutputStream  out = new ByteArrayOutputStream()) {
           //读取缓冲区
           byte[] buff = new byte[1024];
           int len = -1;
           while((len = in.read(buff)) != -1) {
               out.write(buff,0,len);
           }
           byte[] byteCodeData = out.toByteArray();
           return byteCodeData;
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }
}
public class TestMyClassLoader {

    public static void main(String[] args) throws IOException {
        MyclassLoader myclassLoader = new MyclassLoader();
        Class memberCls1 = myclassLoader.loadClasses("com.github.FWJacky.classLoader.Member");
        Class memberCls2 = Member.class;
        Class memberCls3 = new Member().getClass();
        System.out.println(memberCls1.getClassLoader());
        System.out.println(memberCls2.getClassLoader());
        System.out.println(memberCls3.getClassLoader());
        //??????
        System.out.println(memberCls1 == memberCls2);//false
        System.out.println(memberCls2 == memberCls3);//true
//        System.out.println(memberCls1);

    }
}
