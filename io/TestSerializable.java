package io;

import java.io.*;
import java.util.Date;


/**
 * @ClassName TestSerializable
 * @Description TODO
 * @Author L
 * @Date 2019/5/28 19:45
 * @Version 1.0
 **/
public class TestSerializable {

    public static void code1() {
        //序列化
        Person person = new Person();
        person.setAge(20);
        person.setBirthday(new Date());
        person.setName("Tom");
        person.setSkills(new String[]{"Java", "MySQL", "C++"});
        try (ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("D:" + File.separator
                + "TestCode" + File.separator + "iotest" + File.separator + "Person.txt"))) {
            oout.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void code2() {
        //反序列化
        File file = new File("D:" + File.separator + "TestCode" + File.separator + "iotest" + File.separator + "Person.txt");
        try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file))) {
            try {
                Object object = oin.readObject();
                System.out.println(object);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        code1();
        code2();
    }
}
