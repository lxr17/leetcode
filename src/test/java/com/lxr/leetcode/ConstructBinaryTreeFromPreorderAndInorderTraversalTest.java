package com.lxr.leetcode;

import org.junit.Test;

public class ConstructBinaryTreeFromPreorderAndInorderTraversalTest {

    @Test
    public void buildTree() {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};

        ConstructBinaryTreeFromPreorderAndInorderTraversal.TreeNode treeNode = new ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(preorder, inorder);

        System.out.println(treeNode);
    }

    @Test
    public void buildTree2() {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};

        ConstructBinaryTreeFromPreorderAndInorderTraversal.TreeNode treeNode = new ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree2(preorder, inorder);

        System.out.println(treeNode);
    }

}
