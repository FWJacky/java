/**
 * @ClassName Solution6
 * @Description TODO
 * @Author L
 * @Date 2019/7/25 20:35
 * @Version 1.0
 **/
public class Solution6 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length < 0) {
            return 0;
        }
        int maxSum = array[0];
        int curSum = array[0];
        for(int i = 1;i < array.length;i++) {
            curSum = Math.max(curSum + array[i],array[i]);
            maxSum = Math.max(maxSum,curSum);
        }
        return maxSum;
    }
}
