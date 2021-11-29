package com.TreeTheme;

import com.TreeTheme.com.TreeNode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author agicher
 * @date 2021/11/29 19:40
 * {@link = https://leetcode-cn.com/problems/hPov7L/}
 */
public class offer_2_44 {

    public List<Integer> largestValues(TreeNode root) {
        if ( root == null )
            return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        queue.offer(root);
/**
 * 改进
 *
 * queue.size() 就是当前层的数目   只有处理完当前的Node（ size == 0）才会去下一层处理
 */
        int level_count = 1;
        while (!queue.isEmpty()){
            int next_count = 0;
            int curMax = Integer.MIN_VALUE;
            while (level_count != 0){
                TreeNode node = queue.poll();
                if (node.val > curMax)
                    curMax = node.val;
                level_count--;

                if (node.left != null){
                    queue.offer(node.left);
                    next_count++;
                }
                if (node.right != null){
                    queue.offer(node.right);
                    next_count++;
                }
            }
            res.add(curMax);
            level_count = next_count;
        }

        return res;
    }
}
