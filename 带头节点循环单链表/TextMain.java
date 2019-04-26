package 带头节点循环单链表;

/**
 * @ClassName TextMain
 * @Description TODO
 * @Author L
 * @Date 2019/4/20 14:43
 * @Version 1.0
 **/
public class TextMain {
    public static void main(String[] args) throws InterruptedException {
        HeadSingleList headSingleList = new HeadSingleList();
//        headSingleList.addFirst(10);
//        headSingleList.addFirst(20);
//        headSingleList.addFirst(30);
//        headSingleList.addFirst(40);
        headSingleList.addLast(10);
        headSingleList.addLast(20);
        headSingleList.addLast(30);
        headSingleList.addLast(40);
        headSingleList.addLast(80);
        headSingleList.addLast(40);
        headSingleList.addLast(60);
        headSingleList.addLast(40);
        headSingleList.clear();
//        headSingleList.removeAllKey(100);
//        headSingleList.addindex(0,50);
//        System.out.println(headSingleList.getLength());
//        System.out.println(headSingleList.contains(50));
//        headSingleList.display();
        Thread.sleep(1000);
        System.out.println(5);
    }
}
