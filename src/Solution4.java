/**
 * @ClassName Solution4
 * @Description TODO
 * @Author L
 * @Date 2019/7/25 19:42
 * @Version 1.0
 **/
public class Solution4 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0) {
            return 0;
        }
        int row  = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] pathNum = new int[row][col];
        for (int i = 0; i < row; i++) {
            if(obstacleGrid[i][0] == 1) {
                break;
            }else {
                pathNum[i][0] = 1;
            }
        }
        for (int i = 0; i < col; i++) {
            if(obstacleGrid[0][i] == 1) {
                break;
            }else {
                pathNum[0][i] = 1;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if(obstacleGrid[i][j] == 0) {
                    pathNum[i][j] = pathNum[i-1][j] + pathNum[i][j-1];
                }
            }
        }
        return pathNum[row - 1][col - 1];
    }
}
