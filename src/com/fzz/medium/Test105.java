package com.fzz.medium;


public class Test105 {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        Solution105 s = new Solution105();
        TreeNode root = s.buildTree(preorder,inorder);
        System.out.println(root);
    }
}


/**
 * 思路：
 * 数据结构：根据前序遍历（根左右）和中序遍历（左根右）的遍历顺序，可以得出：
 * 前序遍历开头的就是根节点，找到根节点在中序遍历中的位置，该位置左侧构成左子树，右侧构成右子树，
 * 可以运用递归来构造整棵树
 * 关键：
 * 注意边界问题
 */
class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        int index = getRootIndex(root.val, inorder);
        buildChildTree(root, preorder, 1, preorder.length - 1, inorder, 0, inorder.length - 1, index);
        return root;
    }


    private static void buildChildTree(TreeNode root, int[] preorder,
                                       int start, int end,
                                       int[] inorder, int start2, int end2,
                                       int indexOfRoot) {
        //有左子树
        if (indexOfRoot > start2) {
            root.left = new TreeNode(preorder[start]);
            int rootIndex = getRootIndex(root.left.val, inorder);
            buildChildTree(root.left, preorder, start + 1, indexOfRoot + start < preorder.length ? indexOfRoot + start : end, inorder, start2, indexOfRoot - 1, rootIndex);
        }
        //有右子树
        if (indexOfRoot < end2) {
            root.right = new TreeNode(preorder[indexOfRoot - start2 + start]);
            int rootIndex = getRootIndex(root.right.val, inorder);
            buildChildTree(root.right, preorder, indexOfRoot - start2 + start + 1, end, inorder, indexOfRoot + 1, end2, rootIndex);
        }

    }

    private static int getRootIndex(int value, int[] inorder) {
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (value == inorder[i]) {
                index = i;
                break;
            }
        }
        return index;
    }
}