package com.github.FWJacky;

/**
 * @ClassName Point3
 * @Description TODO
 * @Author L
 * @Date 2019/5/9 16:31
 * @Version 1.0
 **/
public class Point3<T,E> {
    private T x;
    private E y;

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public E getY() {
        return y;
    }

    public void setY(E y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point3{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
