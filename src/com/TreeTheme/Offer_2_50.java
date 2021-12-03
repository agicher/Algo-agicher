package com.TreeTheme;

import com.TreeTheme.com.TreeNode;

/**
 * @author agicher
 * @date 2021/12/3 11:06
 * {@link = https://leetcode-cn.com/problems/6eUYwP/}
 * 路径之和 等于 给定 target  不必从 root 开始
 */
public class Offer_2_50 {

    // 两次 dfs 第一次 表示从任意节点开始   第二次  表示遍历以该节点为根节点满足 要求的节点
    //>>TODO 前缀和 也可以得出答案

    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        return sumNode(root,targetSum) + pathSum(root.left,targetSum) +pathSum(root.right,targetSum);

    }

    private static int sumNode(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int ret = 0;
        if (root.val == targetSum) ret++;
        ret += sumNode(root.left,targetSum - root.val);
        ret += sumNode(root.right,targetSum - root.val);
        return ret;

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        System.out.println(pathSum(root,3));
    }







}
