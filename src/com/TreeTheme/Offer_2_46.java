package com.TreeTheme;

import com.TreeTheme.com.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author agicher
 * @date 2021/11/29 20:47
 * {@link = https://leetcode-cn.com/problems/WNC0Lk/}
 */
public class Offer_2_46 {

    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ans.add(queue.peek().val);
            while (size != 0) {
                TreeNode node = queue.poll();
                size--;
                if (node.right != null) queue.offer(node.right);
                if (node.left != null) queue.offer(node.left);
            }
        }
        return ans;
    }


}
