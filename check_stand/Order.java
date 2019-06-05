package check_stand;

import java.util.*;
import java.util.List.*;

/**
 * @ClassName Order
 * @Description TODO
 * @Author L
 * @Date 2019/6/4 23:25
 * @Version 1.0
 **/
public class Order {

    //做成单例模式
    private final static Order order = new Order();
    private Order(){}
    public static Order getInstance() {
        return order;
    }

    private Integer goodsNumber;

    private List<Goods> list = new LinkedList<>();

    {
        list.add(new Goods(1,"牛奶",5D));
        list.add(new Goods(2,"饼干",5.5D));
        list.add(new Goods(3,"面包",7D));
    }



}
