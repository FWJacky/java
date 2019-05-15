package com.bit.Testenum;

/**
 * @ClassName TestEnum
 * @Description TODO
 * @Author L
 * @Date 2019/5/15 18:08
 * @Version 1.0
 **/
enum Color {
    RED("红色"),GREEN("绿色"),BLUE("蓝色");

    private String title;

    //构造方法是私有的
    private Color (String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}

//class Color {
//    private String title;
//    public static final int RED_FLAG = 1;
//    public static final int GREEN_FLAG = 2;
//    public static final int BLUE_FLAG = 3;
//    private static final Color RED = new Color("红色");
//    private static final Color GREEN = new Color("绿色");
//    private static final Color BLUE = new Color("蓝色");
//    private Color(String title) {
//        this.title = title;
//    }
//    public static Color getInstance(int ch) {
//        switch (ch) {
//            case RED_FLAG:
//                return RED;
//            case GREEN_FLAG:
//                return GREEN;
//            case BLUE_FLAG:
//                return BLUE;
//                default:
//                    return null;
//        }
//    }
//
//    @Override
//    public String toString() {
//        return this.title;
//    }
//}

interface IColor {
        String getColor();
}
//枚举实现接口
enum Color2 implements IColor {
    RED("红色"),GRENN("绿色"),BLUE("蓝色");
    private String title;
    private Color2(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }

    @Override
    public String getColor() {
        return this.title;
    }
}
public class TestEnum {
    public static void main(String[] args) {
//        Color color = Color.BLUE;
//        System.out.println(color);
//        System.out.println(Color.getInstance(Color.BLUE_FLAG));
        //利用Enum类中的ordinal()方法获得枚举元素的下标，利用name()方法获得枚举名字
//        System.out.println(Color.BLUE.ordinal() + "=" + Color.BLUE.name());
        //利用Enum类中的values()方法打印出枚举类中的所有元素
//        for (Color color: Color.values()) {
//            System.out.println(color);
//        }
//        System.out.println(Color.BLUE);
        IColor iColor = Color2.BLUE;
        System.out.println(iColor.getColor());
    }
}
