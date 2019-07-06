package com.github.producerandcustomermodel;

/**
 * @ClassName Goods
 * @Description TODO
 * @Author L
 * @Date 2019/7/6 17:36
 * @Version 1.0
 **/
public class Goods {

    private String id;
    private String name;
    private Double price;

    public Goods(String id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
