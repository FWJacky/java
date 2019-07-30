/**
 * @ClassName Solution8
 * @Description TODO
 * @Author L
 * @Date 2019/7/25 21:35
 * @Version 1.0
 **/

class TreeNode {
     int val;
      TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class Solution8 {
    int preIndex = 0;
    public int findIndex(int[] in,int val,int begin,int inend) {
        for (int i = begin; i <= inend; i++) {
            if(in[i] == val) {
                return i;
            }
        }
        return -1;
    }
    public TreeNode reConstructBinaryTreeChild(int[] pre,int[] in,int begin, int end) {
        if(begin > end) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preIndex]);
        int rootIndex = findIndex(in, root.val, 0 ,in.length-1 );
        preIndex++;
        root.left = reConstructBinaryTreeChild(pre, in,begin,rootIndex-1);
        root.right = reConstructBinaryTreeChild(pre, in,rootIndex+1,end);
        return root;
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(in == null || pre == null) {
            return null;
        }
        return reConstructBinaryTreeChild(pre, in, 0, in.length-1);
    }
}
