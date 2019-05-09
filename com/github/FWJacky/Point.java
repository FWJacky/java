package com.github.FWJacky;

/**
 * @ClassName Point
 * @Description TODO
 * @Author L
 * @Date 2019/5/9 15:56
 * @Version 1.0
 **/
public class Point {

    private Object x;

    private Object y;

    public Object getX() {
        return x;
    }

    public void setX(Object x) {
        this.x = x;
    }

    public Object getY() {
        return y;
    }

    public void setY(Object y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
