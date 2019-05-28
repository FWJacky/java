package io;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * @ClassName TestRemove
 * @Description TODO
 * @Author L
 * @Date 2019/5/28 15:23
 * @Version 1.0
 **/
public class TestRemove {
    public static void main(String[] args) {
        String[] data = {"D:\\TestCode\\iotest\\data-a.txt", "D:\\TestCode\\iotest\\data-b.txt"};
        String data2 = "D:\\TestCode\\iotest\\b";
        move(data, data2);
    }

    public static void move(String[] scrfile, String descfile) {
        if (scrfile.length == 0) {
            throw new IllegalArgumentException("scrfile is not null");
        }
        //创建目的路径，用于确定移动文件到哪个文件夹（目录）中
        File desc = new File(descfile);
        if (!desc.exists()) {
            desc.mkdirs();
        }
        for (String aScrfile : scrfile) {
            File scr = new File(aScrfile);
//            System.out.println(scr.getName());
            if (!scr.exists()) {
                throw new IllegalArgumentException("file is not exists or there is not file ");
            }
            //移动文件，必须要在目的路径下创建文件名，否则原文件的内容没有存放的地方
            //将移动的文件中的内容保存到创建的文件名中
            if (scr.renameTo(new File(desc, scr.getName()))) {
                System.out.println("移动成功");
            } else {
                System.out.println("移动失败");
            }
        }
    }

}
