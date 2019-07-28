/**
 * @ClassName Test3
 * @Description TODO
 * @Author L
 * @Date 2019/7/1 21:35
 * @Version 1.0
 **/

class Person {

    private String name;
    private int age;

    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Student extends Person {

    private String skill;

    public Student(String name, int age,String skill) {
        super(name, age);
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Student{" +
                "skill='" + skill + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Person person = new Student("zhang", 20,"java");

        System.out.println(person);
    }
}
