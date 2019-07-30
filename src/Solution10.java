

/**
 * @ClassName Solution10
 * @Description TODO
 * @Author L
 * @Date 2019/7/26 1:15
 * @Version 1.0
 **/
public class Solution10 {

    public void Mirror(TreeNode root) {
        if(root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
