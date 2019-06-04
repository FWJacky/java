package system12306;

/**
 * @ClassName Ticket
 * @Description TODO
 * @Author L
 * @Date 2019/6/3 23:57
 * @Version 1.0
 **/
public class Ticket {
    /*车票中的属性
     *   起点站
     *   终点站
     *   票价
     *   */

    //像User类 Ticket类  没有任何逻辑
    //只是包含一些基本属性   每一个对象都像一个小容器
    //一个对象包含好很多属性  增强可读性  类名 属性名 属性类型不一样
    //POJO：javaBean   平凡简单的原始类

    //起始站名
    private String start;
    //终点站名
    private String end;
    //票价
    private Float price; //当从数据库空读取出一个null时，float存不了null，而Float可以，Float只是相对安全一些

    public Ticket() {
    }

    public Ticket(String start, String end, Float price) {
        this.start = start;
        this.end = end;
        this.price = price;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    //为了让打印输出时变得方便，打印一个对象就可以了
    @Override
    public String toString() {
        return "Ticket{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", price=" + price +
                '}';
    }
}
