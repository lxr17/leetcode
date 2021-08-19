package com.lxr.leetcode;

import org.junit.Test;

public class ConvertSortedArrayToBinarySearchTreeTest {

    @Test
    public void sortedArrayToBST() {
        //int[] nums = new int[]{-10, -3, 0, 5, 9};
        //int[] nums = new int[]{3, 5};
        int[] nums = new int[]{6};

        ConvertSortedArrayToBinarySearchTree.TreeNode treeNode = new ConvertSortedArrayToBinarySearchTree().sortedArrayToBST(nums);

        System.out.println(treeNode);
    }

    @Test
    public void sortedArrayToBST2() {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        //int[] nums = new int[]{3, 5};
        //int[] nums = new int[]{6};

        ConvertSortedArrayToBinarySearchTree.TreeNode treeNode = new ConvertSortedArrayToBinarySearchTree().sortedArrayToBST2(nums);

        System.out.println(treeNode);
    }
}
