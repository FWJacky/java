import java.util.ArrayList;

/**
 * @ClassName Solution11
 * @Description TODO
 * @Author L
 * @Date 2019/7/26 1:18
 * @Version 1.0
 **/
public class Solution11 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix.length == 0) {
            return null;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < col; i++) {
            result.add(matrix[0][i]);
        }
        for (int i = 0; i < row; i++) {
            result.add(matrix[col-1][i]);
        }
        // TODO  找到下标的关系  动态规划
        return result;
    }
}
