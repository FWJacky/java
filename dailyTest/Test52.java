package dailyTest;

/**
 * @ClassName Test52
 * @Description TODO
 * @Author L
 * @Date 2019/7/26 15:10
 * @Version 1.0
 **/
public class Test52 {
    public int maxDeepth(Test41.TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftDeepth = maxDeepth(root.left);
        int rightDeepth = maxDeepth(root.right);
        return leftDeepth > rightDeepth ? leftDeepth+1  : rightDeepth+1;
    }
    public boolean isBalance(Test41.TreeNode root) {
        // write code here
        if(root == null) {
            return true;
        }
        int leftDeepth = maxDeepth(root.left);
        int rightDeepth = maxDeepth(root.right);
        int len = Math.abs(leftDeepth - rightDeepth);
        if(len > 1) {
            return false;
        }
        return true;
    }
}
