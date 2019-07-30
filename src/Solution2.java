import java.util.ArrayList;

/**
 * @ClassName Solution2
 * @Description TODO
 * @Author L
 * @Date 2019/7/25 18:51
 * @Version 1.0
 **/
public class Solution2 {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle.size() == 0) {
            return 0;
        }
        // F(0,0) = a[0,0]
        // F(i,0) = F(i-1,0) + a[i][0]
        int row = triangle.size();
        for (int i = row-2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int min = Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1));
                triangle.get(i).set(j,triangle.get(i).get(j)+min);
            }
        }
        return triangle.get(0).get(0);
    }
}
