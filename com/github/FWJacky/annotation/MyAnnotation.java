package com.github.FWJacky.annotation;

import java.lang.annotation.*;

/**
 * @ClassName MyAnnotation
 * @Description TODO
 * @Author L
 * @Date 2019/5/22 21:05
 * @Version 1.0
 **/
/*
1. @interface
2. @Retention指定保存范围
3. @Target 指定注解标识的位置
4. 定义方法
    4.1 定义默认值
Spring框架大量使用Annotation
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyAnnotation {
    //方法
    String name() default "无名";

    int age() default 18;
}
