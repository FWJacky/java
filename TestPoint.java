import com.github.FWJacky.Point;

/**
 * @ClassName TestPoint
 * @Description TODO
 * @Author L
 * @Date 2019/5/9 15:58
 * @Version 1.0
 **/
public class TestPoint {

    public static void main(String[] args) {
        {
            Point intPoint = new Point();
            intPoint.setX(10);
            intPoint.setY(20);
            int x = (int) intPoint.getX();
            int y = (int) intPoint.getY();
            System.out.println("x = " + x + ",y = " + y);
        }
        {
            Point strPoint = new Point();
            strPoint.setX("东经120度");
            strPoint.setY("北纬30度");
            String x = (String) strPoint.getX();
            String y = (String) strPoint.getY();
            System.out.println("x = " + x + ",y = " + y);
        }
        {
            Point strPoint = new Point();
            strPoint.setX("东经120度");
            strPoint.setY(30);
            String x = (String) strPoint.getX();
            int y = (int) strPoint.getY();
            System.out.println("x = " + x + ",y = " + y);
        }
        {
            Point strPoint = new Point();
            strPoint.setX("东经120度");
            strPoint.setY(30);
            printPoint(strPoint);
        }
    }

    public static void printPoint(Point strPoint) {
        String x = (String) strPoint.getX();
        String y = (String) strPoint.getY();
        System.out.println("Point(x,y)=(" + x + ", " + y + ")");
    }
}
