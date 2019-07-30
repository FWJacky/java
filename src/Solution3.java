/**
 * @ClassName Solution3
 * @Description TODO
 * @Author L
 * @Date 2019/7/25 19:31
 * @Version 1.0
 **/
public class Solution3 {
    public int uniquePaths(int m, int n) {
        if(m < 0) {
            return 0;
        }
        int[][] pathNum = new int[m][n];
        for (int i = 0; i < m; i++) {
            pathNum[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            pathNum[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                pathNum[i][j] = pathNum[i-1][j] + pathNum[i][j-1];
            }
        }
        return pathNum[m-1][n-1];
    }
}
