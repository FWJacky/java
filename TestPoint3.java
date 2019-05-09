import com.github.FWJacky.Point3;

/**
 * @ClassName TestPoint3
 * @Description TODO
 * @Author L
 * @Date 2019/5/9 16:32
 * @Version 1.0
 **/
public class TestPoint3 {

    public static void main(String[] args) {
        Point3<Integer,String> point = new Point3<>();
        point.setX(10);
        point.setY("东经120度");
        System.out.println(point.getX() + " " + point.getY());

        Point3<Integer,Integer> point2 = new Point3<>();
        point2.setX(10);
        point2.setY(20);
        System.out.println(point2.getX() + " " + point2.getY());
    }
}
