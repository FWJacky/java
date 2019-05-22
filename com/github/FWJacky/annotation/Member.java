package com.github.FWJacky.annotation;

import java.io.Serializable;

/**
 * @ClassName Member
 * @Description TODO
 * @Author L
 * @Date 2019/5/22 21:03
 * @Version 1.0
 **/
@SuppressWarnings(value = {"unused"})
@Deprecated
@MyAnnotation(name = "中国",age = 20)
public class Member implements Serializable {

    @Override
    @Deprecated
    public String toString() {
        return super.toString();
    }
}

