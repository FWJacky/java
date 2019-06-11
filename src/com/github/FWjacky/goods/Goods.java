package com.github.FWjacky.goods;

/**
 * @ClassName Goods
 * @Description TODO
 * @Author L
 * @Date 2019/6/11 20:24
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

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
