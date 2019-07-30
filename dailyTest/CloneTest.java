package com.github.dailyTest;

/**
 * @ClassName CloneTest
 * @Description TODO
 * @Author L
 * @Date 2019/7/8 19:29
 * @Version 1.0
 **/
class Teacher{
    private int age;
    private String name;
}

class Student implements Cloneable {
    private int age;
    private String name;
    private Teacher teacher;

    public Student clone(){
        Student stu = null;
        stu = new Student().clone();
        return stu;
    }

}
public class CloneTest {
}
