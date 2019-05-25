package io;

import com.github.FWJacky.Mymath;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @ClassName MyPrintStream
 * @Description TODO
 * @Author L
 * @Date 2019/5/25 23:52
 * @Version 1.0
 **/
public class MyPrintStream {
    private OutputStream out;

    public MyPrintStream(OutputStream out) {
        this.out = out;
    }

    public void write(int value) {
        this.write(String.valueOf(value));
    }

    public void write(double value) {
        this.write(String.valueOf(value));
    }

    public void write(String value) {
        byte[] data = value.getBytes();
        try {
            this.out.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void flush() {
        try {
            this.out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try(OutputStream out = new FileOutputStream("D:" + File.separator + "TestCode" + File.separator
        +"iotest")){

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}


