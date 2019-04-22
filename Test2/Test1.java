/**
 * @ClassName Test1
 * @Description TODO
 * @Author L
 * @Date 2019/4/11 15:57
 * @Version 1.0
 **/
public class Test1 {
    public static void main(String[] args) {
        Computer computer = new Computer();
//        UDisk uDisk = new UDisk();
////        PrintDisk printDisk = new PrintDisk();
//        computer.plugin(new UDisk());  //匿名对象
//        computer.plugin(new PrintDisk());
        USB uDisk = new UDisk();
        USB printDisk = new PrintDisk();
        computer.plugin(uDisk);
        computer.plugin(printDisk);
    }
}
