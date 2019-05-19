package com.github.FWJacky;

/**
 * @ClassName GetSuperClassMessage
 * @Description TODO
 * @Author L
 * @Date 2019/5/18 13:45
 * @Version 1.0
 **/

interface IFruit{}
interface IMessage{}
class CLS implements IFruit,IMessage{}
public class GetSuperClassMessage {

    public static void main(String[] args) {
        //取得父类的信息，首先一定要得到当前类的Class对象，才可以进行操作  -> com.github.FWJacky.CLS
        Class<?> cls = CLS.class;
        System.out.println(cls);
        //获得包名 ->  com.github.FWJacky
        //getPackage()得到的是一个对象
        System.out.println(cls.getPackage().getName());
        //获得类名 ->  CLS
        //getSimpleName()得到的是字符串
        System.out.println(cls.getSimpleName());
        //获得类的全限定名  ->  com.github.FWJacky.CLS
        //getName()得到是字符串
        System.out.println(cls.getName());
        //获得父类的Class对象 -> java.lang.Object
        //getSuperclass()得到的也是一个对象
        System.out.println(cls.getSuperclass().getName());
        //获得实现的父接口  -> com.github.FWJacky.IFruit   com.github.FWJacky.IMessage
        //getInterfaces()得到的还是一个对象，可以调用Class对象的方法 例如调用getName()
        Class<?>[] interfaces = cls.getInterfaces();
        for (Class<?> interface1 : interfaces) {
            System.out.println(interface1.getName());
        }
    }

}
