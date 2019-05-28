package io;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

/**
 * @ClassName Person
 * @Description TODO
 * @Author L
 * @Date 2019/5/28 19:40
 * @Version 1.0
 **/
public class Person implements Serializable {

    private transient Integer age;
    private String name;
    private String[] skills;
    private Date birthday;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", skills=" + Arrays.toString(skills) +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(age, person.age) &&
                Objects.equals(name, person.name) &&
                Arrays.equals(skills, person.skills) &&
                Objects.equals(birthday, person.birthday);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(age, name, birthday);
        result = 31 * result + Arrays.hashCode(skills);
        return result;
    }
}
