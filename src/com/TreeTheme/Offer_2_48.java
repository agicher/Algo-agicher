package com.TreeTheme;

import com.TreeTheme.com.TreeNode;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * @author agicher
 * @date 2021/11/30 19:22
 * {@link = https://leetcode-cn.com/problems/h54YBf/}
 */
public class Offer_2_48 {
    // Your Codec object will be instantiated and called as such:
    // Codec ser = new Codec();
    // Codec deser = new Codec();
    // TreeNode ans = deser.deserialize(ser.serialize(root));
    // Encodes a tree to a single string.


    /**
     *本质是二叉树的preOrder遍历
     * 根据遍历的结果，进行二叉树的重建
     */
    public static String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        preOrder(root,str);
        return str.toString();
    }

    private static void preOrder(TreeNode root, StringBuilder str) {
        if (root == null)  {
            str.append("null,");
            return;
        }
        str.append(root.val + ",") ;
        preOrder(root.left,str);
        preOrder(root.right,str);
    }


    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        // handler string -> nums
        // nums -> binary tree

        String[] nums = data.split(",");
        int i = 0;
        return handlerNumsToNode(nums,i);
    }

    private static TreeNode handlerNumsToNode(String[] nums, int i) {
        if ("null".equals(nums[i]) ) {
            i++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(nums[i]));
        i++;
        node.left = handlerNumsToNode(nums,i);
        node.right = handlerNumsToNode(nums,i);
        return node;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        deserialize(serialize(root));
    }
}
