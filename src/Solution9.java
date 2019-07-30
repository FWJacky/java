/**
 * @ClassName Solution9
 * @Description TODO
 * @Author L
 * @Date 2019/7/26 0:50
 * @Version 1.0
 **/
/**
    输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class Solution9 {

    public boolean isSameTree(TreeNode p,TreeNode q) {
        if(q==null) {
            return true;
        }
        if(p == null) {
            return false;
        }
        if(p.val != q.val) {
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null) {
            return false;
        }
        if(isSameTree(root1,root2)) {
            return true;
        }
        if(HasSubtree(root1.left,root2)) {
            return true;
        }
        if(HasSubtree(root1.right,root2)) {
            return true;
        }
        return false;
    }
}
