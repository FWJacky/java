package dailyTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Test56
 * @Description TODO  学分绩点
 * @Author L
 * @Date 2019/7/29 10:00
 * @Version 1.0
 **/
public class Test56 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = Integer.parseInt(in.nextLine());
            double[] course = new double[n];
            double courseSum = 0;
            double gpaSum = 0;
            String[] courseStr = in.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                course[i] = Double.parseDouble(courseStr[i]);
            }
            double[] grade = new double[n];
            String[] gradeStr = in.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                grade[i] = Double.parseDouble(gradeStr[i]);
            }
            for (int i = 0; i < n; i++) {
                courseSum += course[i];
                if(grade[i] >= 90 && grade[i] <= 100) {
                    gpaSum += 4*course[i];
                }
                if(grade[i] >= 85 && grade[i] <= 89) {
                    gpaSum += 3.7*course[i];
                }
                if(grade[i] >= 82 && grade[i] <= 84) {
                    gpaSum += 3.3*course[i];
                }if(grade[i] >= 78 && grade[i] <= 81) {
                    gpaSum += 3.0*course[i];
                }if(grade[i] >= 75 && grade[i] <= 77) {
                    gpaSum += 2.7*course[i];
                }if(grade[i] >= 72 && grade[i] <= 74) {
                    gpaSum += 2.3*course[i];
                }if(grade[i] >= 68 && grade[i] <= 71) {
                    gpaSum += 2.0*course[i];
                }if(grade[i] >= 64 && grade[i] <= 67) {
                    gpaSum += 1.5*course[i];
                }if(grade[i] >= 60 && grade[i] <= 63) {
                    gpaSum += 1.0*course[i];
                }if(grade[i] < 60) {
                    gpaSum += 0.0*course[i];
                }
            }
            double GPA = gpaSum / courseSum;
            System.out.printf("%.2f",GPA);
        }
    }
}
