package dailyTest;

/**
 * @ClassName Test85
 * @Description TODO  最近公共祖先
 * @Author L
 * @Date 2019/8/15 10:21
 * @Version 1.0
 **/
public class Test85 {

    public int getLCA(int a, int b) {
        // write code here
        while (a != b) {
            if (a > b) {
                a = a / 2;
            } else {
                b = b / 2;
            }
        }
        return a;
    }
}
