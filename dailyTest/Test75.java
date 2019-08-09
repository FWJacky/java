package dailyTest;

import java.util.Scanner;

/**
 * @ClassName Test75
 * @Description TODO  输入球的中心点和球上某一点的坐标，计算球的半径和体积
 * @Author L
 * @Date 2019/8/8 23:17
 * @Version 1.0
 **/
public class Test75 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double x0 = scanner.nextDouble();
            double y0 = scanner.nextDouble();
            double z0 = scanner.nextDouble();
            double x1 = scanner.nextDouble();
            double y1 = scanner.nextDouble();
            double z1 = scanner.nextDouble();
            double x = x1 - x0;
            double y = y1 - y0;
            double z = z1 - z0;
            double r = Math.sqrt(Math.pow(x,2)+Math.pow(y,2)+Math.pow(z,2));
            double v = 4*Math.acos(-1)* Math.pow(r,3)/3;
            System.out.printf("%.3f",r);
            System.out.println();
            System.out.printf("%.3f",v);
        }
    }
}
