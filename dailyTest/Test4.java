/**
 * @ClassName Test4
 * @Description TODO
 * @Author L
 * @Date 2019/7/2 12:46
 * @Version 1.0
 **/
public abstract class Test4 {

    public abstract void test();
    //抽象方法不用加{}

    public int num = 10;
//    public void test(int num) {
//        System.out.println(num);
//    }

    public int test(int num2) {
       return num2;
    }

    //方法名可以与class名相同
    public int Test4(int num3){
        return num3;
    }

}
