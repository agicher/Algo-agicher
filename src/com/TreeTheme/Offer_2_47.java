package com.TreeTheme;

import com.TreeTheme.com.TreeNode;

/**
 * @author agicher
 * @date 2021/11/30 18:43
 * {@link = https://leetcode-cn.com/problems/pOCWxh/}
 */
public class Offer_2_47 {

    /**
     * 本质 是 遍历
     * 删除的条件： 子节点 为 0
     * @param root
     * @return
     */

    // 处理上一层的节点 时 ，可以 让方法 直接返回给变量自身 root.left root.right
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
         root.left = pruneTree(root.left);
         root.right = pruneTree(root.right);
         return root.val == 0 && root.left == null && root.right == null ? null : root;
    }


}
