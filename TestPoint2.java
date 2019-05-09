import com.github.FWJacky.Point;
import com.github.FWJacky.Point2;

/**
 * @ClassName TestPoint2
 * @Description TODO
 * @Author L
 * @Date 2019/5/9 16:18
 * @Version 1.0
 **/
public class TestPoint2 {

    public static void main(String[] args) {
//        Point2<Integer> intPoint = new Point2<>();
//        intPoint.setX(10);
//        intPoint.setY(20);
//        intPoint.setY("东经120度"); //error
//        System.out.println(intPoint.getX() + " " + intPoint.getY());
//        Point2<String> strPoint = new Point2<>();

        Point2<String> strPoint = new Point2<>();
        strPoint.setX("东经120度");
        strPoint.setY("北纬30度");
        System.out.println(strPoint.getX() + " " + strPoint.getY());
    }
}
