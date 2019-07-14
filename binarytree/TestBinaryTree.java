package com.github.binarytree;

import sun.reflect.generics.tree.Tree;

import java.util.List;
import java.util.Stack;

/**
 * @ClassName TestBinaryTree
 * @Description TODO  链式二叉树
 * @Author L
 * @Date 2019/7/14 9:40
 * @Version 1.0
 **/
public class TestBinaryTree {

    class TreeNode {

        //根节点value
        char val;
        //左孩子
        TreeNode left;
        //右孩子
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

    }

    // i是用来记录当前字符串下标
    public int i = 0;

    //根据字符串创建二叉树  递归  先序遍历的方式解答
    TreeNode createTestTree(String s) {
        TreeNode root = null;
        // 2. 如果是#，那么直接下标++
        if (s.charAt(i) == '#') {
            i++;
        } else {   // 1. 如果对应字符不是#，那么创建一个节点
            root = new TreeNode(s.charAt(i));
            i++;
            root.left = createTestTree(s);
            root.right = createTestTree(s);
        }
        return root;
    }

    // 记录子树的节点数
    //public int count = 0;
    // 结点个数
    int getSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getSize(root.left) + getSize(root.right) + 1;
        /**
         第二种写法：定义一个count来计数
         getSize(root.left);
         getSize(root.right);
         count++;
         return count;
         */
    }

    // 叶子结点个数
    int getLeafSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 1;
        }
        return getLeafSize(root.left) + getLeafSize(root.right);
    }

    // 第 k 层结点个数
    int getKLevelSize(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getKLevelSize(root.left, k - 1) + getKLevelSize(root.right, k - 1);
    }

    // 查找，依次在二叉树的 根、左子树、右子树 中查找 value，如果找到，返回结点，否则返回 null
    TreeNode find(TreeNode root, int value) {
        if (root == null) {
            return null;
        }
        if (root.val == value) {
            return root;
        }
        TreeNode rNode = find(root.left, value);
        if (rNode != null) {
            return rNode;
        }
        rNode = find(root.right, value);
        if (rNode != null) {
            return rNode;
        }
        /**
         第二种写法：
         TreeNode rNode = find(root.left,value);
         if(rNode == null) {
         return find(root.right,value);
         }
         return rNode;
         **/
        return null;
    }

    //二叉树的高度
    int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

//         第二种写法：
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight > rightHeight) {
            return leftHeight + 1;
        } else {
            return rightHeight + 1;
        }

//        return height(root.left) > height(root.right) ? height(root.left) +1 : height(root.right)+1;
    }

    //二叉树的前序遍历
    void binaryTreePrevOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        //先找左孩子
        binaryTreePrevOrder(root.left);
        //再找右孩子
        binaryTreePrevOrder(root.right);
    }

    //二叉树的中序遍历
    void binaryTreeInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        //先找左孩子
        binaryTreeInOrder(root.left);
        //先打印root
        System.out.print(root.val + " ");
        //再找右孩子
        binaryTreeInOrder(root.right);
    }

    //二叉树的后序遍历
    void binaryTreePostOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        //先找左孩子
        binaryTreeInOrder(root.left);
        //再找右孩子
        binaryTreeInOrder(root.right);
        System.out.print(root.val + " ");
    }

    //二叉树的前序遍历非递归
    void binaryTreePrevOrderNonR(TreeNode root) {
        // 栈用来存放节点
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        // 记录栈顶元素
        TreeNode top = null;
        // 有两个条件，先判断左树时，当cur=null时，没有!stack.empty()这个条件时，无法进入循环，右树无法遍历到，
        // 但是此时栈内部保存了根节点，栈不为空，所以需要取出栈顶元素，从而进入右树进行遍历
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                System.out.print(cur.val + " ");
                stack.push(cur);
                cur = cur.left;
            }
            top = stack.pop();
            cur = top.right;
        }
    }

    //二叉树的中序遍历非递归
    void binaryTreeInOrderNonR(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode top = null;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            top = stack.pop();
            System.out.print(top.val + " ");
            cur = top.right;
        }
    }

    //二叉树的后序遍历非递归
    void binaryTreePostOrderNonR(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        // pre用来标记节点是否已经遍历过，并且已经入过栈了，不需要再次入栈了
        TreeNode pre = null;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 将cur置为null后，cur为pre的父亲节点
            cur = stack.peek();
            // 判断条件为，如果右节点为null，或者右节点等于上次打印的pre，说明此时节点的右节点已经打印了，接下来就是打印当前节点的值
            if(cur.right == null || cur.right == pre) {
                System.out.print(cur.val + " ");
                stack.pop();
                pre = cur; // pre = cur  代表cur已经打印
                cur = null; // 将当前cur置为null
            }else {
                cur = cur.right;
            }
        }
    }

    public static void main(String[] args) {
        TestBinaryTree tbt = new TestBinaryTree();
        String str = "ABC##DE#G##F###";
        //传入的必须是满二叉树，否则会产生下标越界异常（运行时异常）
        TestBinaryTree.TreeNode root = tbt.createTestTree(str);
//        System.out.println(tbt.getSize(root));
//        System.out.println(tbt.getLeafSize(root));
//        System.out.println(tbt.getKLevelSize(root, 5));
//        System.out.println(tbt.find(root, 'B').val);
//        System.out.println(tbt.height(root));
//       tbt.binaryTreeInOrderNonR(root);
//        System.out.println();
//       tbt.binaryTreePrevOrderNonR(root);
//        System.out.println();
        tbt.binaryTreePostOrderNonR(root);
    }
}
