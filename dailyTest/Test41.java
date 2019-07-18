package com.github.dailyTest;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Test41
 * @Description TODO
 * @Author L
 * @Date 2019/7/18 21:09
 * @Version 1.0
 **/
public class Test41 {
    static int i;
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public void Mirror(TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left!=null) {
            Mirror(root.left);
        }
        if(root.right!=null) {
            Mirror(root.right);
        }
    }
}

