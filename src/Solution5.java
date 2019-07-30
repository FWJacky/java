/**
 * @ClassName Solution5
 * @Description TODO
 * @Author L
 * @Date 2019/7/25 20:03
 * @Version 1.0
 **/
public class Solution5 {
    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        if (row < 0) {
            return 0;
        }
        for (int i = 1; i < row; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < col; i++) {
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i <= row - 1; i++) {
            for (int j = 1; j <= col - 1; j++) {
                int min = Math.min(grid[i - 1][j], grid[i][j - 1]);
                grid[i][j] = grid[i][j] + min;
            }
        }
        return grid[row - 1][col - 1];
    }
}
