package io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName TestSystem
 * @Description TODO
 * @Author L
 * @Date 2019/5/25 16:35
 * @Version 1.0
 **/
public class TestSystem {

    public static void main(String[] args) throws IOException {
//        System.out.println("Hello World");
        //System java.lang.System类
        //out    System类的静态属性  out对象  类型PrintStream
        //println()  PrintStream成员方法

//       try {
//           Integer.parseInt("abc");
//       }catch (NumberFormatException e) {
//           System.out.println(e.getMessage());
//           System.err.println(e.getMessage());
//       }

//         系统输出
//        PrintStream out = System.out;
//        OutputStream out = System.out;
//       try{
//           out.write("比特科技".getBytes());
//       }catch (IOException e) {
//           e.printStackTrace();
//       }

        //系统输出
//        InputStream in = System.in;
//        try {
//            int b = in.read();
//            System.out.println(b);//如果不强转，输出的结果就是所对应的单个字节的ASCII值
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        InputStream in = System.in;
//        byte[] data = new byte[1024];
//        System.out.println("请输入信息：");
//        int tmp = 0;
//        try {
//            tmp = in.read(data);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("输出内容：" + new String(data,0,tmp));

        //内存流
//        InputStream in = System.in;
//        byte[] data = new byte[5];
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        int len = -1;
//        while((len = in.read(data))!=-1) {
//            out.write(data,0,len);
//            if(len<data.length){
//                break;
//            }
//        }
//        System.out.println(new String(out.toByteArray()));

        InputStream in = System.in;
        byte[] data = new byte[8];
        int len = in.read(data);//返回的是读取的数据长度
        System.out.println("长度：" + len);
        System.out.println(new String(data,0,len));
    }
}
