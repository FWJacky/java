package com.github.FWJacky.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName ISubject   静态代理模式
 * @Description TODO
 * @Author L
 * @Date 2019/5/21 16:56
 * @Version 1.0
 **/
public interface ISubject {
    void eat();
}
//业务类
class RealSubject implements ISubject {

    @Override
    public void eat() {
        System.out.println("饿了要吃饭");
    }
}

//代理类
//class ProxySubject implements ISubject {
//    //有一个属性是代理接口类型
//    private ISubject subject;
//
//    //通过构造方法传入真实业务类的对象
//    public ProxySubject(ISubject subject) {
//        this.subject = subject;
//    }
//
//    public void prepare() {
//        System.out.println("饭前准备食材");
//    }
//
//    public void afterEat() {
//        System.out.println("饭后洗碗");
//    }
//
//    @Override
//    public void eat() {
//        this.prepare();
//        //调用真实业务
//        this.subject.eat();
//        this.afterEat();
//    }
//}

class Factory {

    private Factory(){}

    //创建真实业务类对象
    public static <T> T getInstance(String realClassName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> cls = Class.forName(realClassName);
        return (T) cls.newInstance();
    }

    //创建代理业务类对象
    public static <T> T getInstance(String proxyClassName,Object target) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> cls = Class.forName(proxyClassName);
        Constructor constructor = cls.getConstructor(cls.getInterfaces()[0]);
        return (T) constructor.newInstance(target);
    }

    //得到代理业务类
    public static <T> T getProxyObject(String realClassName,String proxyClassName) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        T realObject = Factory.getInstance(realClassName);
        T proxyObject = Factory.getInstance(proxyClassName,realObject);
        return proxyObject;
    }

    public static <T> T getInstance(String realClassName , String proxyClassName) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        T t = null;
        T realObject = getInstance(realClassName);
        //直接调用代理类的构造方法，传入真实业务类对象  传入的参数类型必须是ISubject类型的
        Constructor<?> constructor = Class.forName(proxyClassName).getDeclaredConstructor(realObject.getClass().getInterfaces()[0]);
        System.out.println(realObject.getClass().getInterfaces()[0]);
        //得到代理类实例化对象
        t = (T) constructor.newInstance(realObject);
        return t;
    }
}

class ProxySubject implements InvocationHandler {

    private Object object;

    public ProxySubject(Object object) {
        this.object = object;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("饭前准备食材");
        Object value = method.invoke(this.object,args);
//        System.out.println(value);
        System.out.println("饭后洗碗");
        return value;
    }
}