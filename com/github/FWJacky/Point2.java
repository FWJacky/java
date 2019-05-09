package com.github.FWJacky;

/**
 * @ClassName Point2
 * @Description TODO
 * @Author L
 * @Date 2019/5/9 16:16
 * @Version 1.0
 **/
public class Point2<T> {
    private T x;

    private T y;

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
