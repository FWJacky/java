package com.github.FWJacky.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * @ClassName TestProxy
 * @Description TODO
 * @Author L
 * @Date 2019/5/22 17:31
 * @Version 1.0
 **/
public class TestProxy {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
//        ISubject realObject = new RealSubject();
//        ISubject proxyObject = new ProxySubject(realObject);
//        proxyObject.eat();

//        ISubject realObject = Factory.getInstance("com.github.FWJacky.proxy.RealSubject");
//        ISubject proxyObject = Factory.getInstance("com.github.FWJacky.proxy.ProxySubject",realObject);

//        ISubject realObject = Factory.getInstance("com.github.FWJacky.proxy.RealSubject");
//        ISubject proxyObject = Factory.getProxyObject("com.github.FWJacky.proxy.RealSubject","com.github.FWJacky.proxy.ProxySubject");
//        ISubject proxyObject = Factory.getInstance("com.github.FWJacky.proxy.RealSubject",
//                "com.github.FWJacky.proxy.ProxySubject");
//        proxyObject.eat();

        System.out.println("动态代理");
        ISubject realSubject = new RealSubject();
        InvocationHandler handler = new ProxySubject(realSubject);
//        System.out.println(handler);
        //代理对象  handler ==> realSubject
        ISubject proxySubject = (ISubject) Proxy.newProxyInstance
                (realSubject.getClass().getClassLoader(),new Class[]{ISubject.class,CharSequence.class},handler);
//        System.out.println(proxySubject);
        proxySubject.eat();
    }
}
