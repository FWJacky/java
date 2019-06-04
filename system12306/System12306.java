package system12306;

import java.util.Vector;

/**
 * @ClassName System123006
 * @Description TODO
 * @Author L
 * @Date 2019/6/3 23:58
 * @Version 1.0
 **/
public class System12306 {

    //设计一个单例模式-----饿汉式单例模式
    private System12306(){}
    private final static System12306 sys= new System12306();
    public static System12306 getInstance() {
        return sys;
    }

    //懒汉式设计模式
//    private static System12306 sysInstance;
//    private System12306(){}
//    public static System12306 getSysInstance(){
//        if(sysInstance==null) {
//            sysInstance = new System12306();
//        }
//        return sysInstance;
//    }


    //有一个属性  该属性是一个集合
    //ArrayList  和   Vector的区别
    //1. ArrayList底层是非线程安全   Vector是线程安全的

    //线程安全
    private Vector<Ticket> tickets = new Vector<>();

    //当前系统创建后给tickets集合赋值
    {
        for (int i = 10; i < 100; i++) { //10-99  90次
            tickets.add(new Ticket("北京"+i,"深圳"+i,(i%5+5)*25F));
        }
    }

    //设计一个方法，用来从集合内获取一张火车票
    public Ticket getTicket() {
        try {
           return tickets.remove(0);
        }catch (Exception e) {
            return null;
        }
    }
}
