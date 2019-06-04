package check_stand;

import java.util.DoubleSummaryStatistics;

/**
 * @ClassName Goods
 * @Description TODO
 * @Author L
 * @Date 2019/6/4 23:22
 * @Version 1.0
 **/
public class Goods {
    private Integer number;
    private String goodsName;
    private Double price;

    public Goods(){}
    public Goods(Integer number, String goodsName, Double price) {
        this.number = number;
        this.goodsName = goodsName;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "number=" + number +
                ", goodsName='" + goodsName + '\'' +
                ", price=" + price +
                '}';
    }
}
