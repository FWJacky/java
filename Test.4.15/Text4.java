import java.util.Arrays;

/**
 * @ClassName Text4
 * @Description TODO
 * @Author L
 * @Date 2019/4/18 20:50
 * @Version 1.0
 **/
class Solution {
    public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == target - nums[i]) {
                        return new int[] { i, j };
                    }
                }
            }
        throw new IllegalArgumentException("No two sum solution");
    }
}
public class Text4 {

        public static void main(String[] args) {
            Solution s = new Solution();
            int[] nums = {2,7,11,19};
            int[] ch = s.twoSum(nums,9);
            for (int i:ch) {
                System.out.print(i+" ");
            }
        }
}
