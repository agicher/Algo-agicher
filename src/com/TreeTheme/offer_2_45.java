package com.TreeTheme;

import com.TreeTheme.com.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author agicher
 * @date 2021/11/29 20:08
 * {@link = https://leetcode-cn.com/problems/LwUNpT/}
 */
public class offer_2_45 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curLevel = new ArrayList<>();
            while (size != 0) {
                TreeNode node = queue.poll();
                curLevel.add(node.val);
                size--;
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            list.add(curLevel);
        }
        List<Integer> lastLevel = list.get(list.size() - 1);
        return lastLevel.get(0);
    }

    /**
     * 优化  list 记录了每一层的 node
     * 但是 本题目 只要求 最后一层的 最左边的一个节点
     * 因此我们只需要记录 每层的第一个节点
     */

    public int findBottomLeftValue2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int ans = 0;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ans = queue.peek().val;
            while (size != 0) {
                TreeNode node = queue.poll();
                size--;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return ans;
    }

    /**
     * 神仙优化
     * 层序遍历  直接从 右 往 左
     *
     * @param root
     * @return
     */

    public int findBottomLeftValue3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) queue.offer(root.right);
            if (root.left != null) queue.offer(root.left);
        }
        return root.val;
    }

}
