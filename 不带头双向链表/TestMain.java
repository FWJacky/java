package 不带头双向链表;

/**
 * @ClassName TestMain
 * @Description TODO
 * @Author L
 * @Date 2019/4/20 16:27
 * @Version 1.0
 **/
public class TestMain {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addindex(0,1994);
        doubleLinkedList.addLast(99);
        doubleLinkedList.addFirst(10);
        doubleLinkedList.addFirst(20);
        doubleLinkedList.addFirst(30);
        doubleLinkedList.addFirst(40);
        doubleLinkedList.addLast(50);
        doubleLinkedList.addLast(60);
        doubleLinkedList.addLast(70);
        doubleLinkedList.addindex(3,1995);
        doubleLinkedList.addindex(9,1994);
//        System.out.println(doubleLinkedList.remove(40));
//        doubleLinkedList.display();
//        System.out.println(doubleLinkedList.remove(70));
//        doubleLinkedList.display();
//        System.out.println(doubleLinkedList.remove(1994));
//        doubleLinkedList.display();
        doubleLinkedList.removeAllKey(1994);
        doubleLinkedList.display();





    }
}
