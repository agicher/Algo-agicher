package com.TreeTheme;

import com.TreeTheme.com.TreeNode;

import java.util.*;

/**
 * @author agicher
 * @date 2021/11/29 16:59
 */
public class Offer_2_43 {

    TreeNode root;
    //save number of no-children(left/right) node
    Deque<TreeNode> deque;

    public Offer_2_43(TreeNode root) {

        this.root = root;
        deque = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.left == null ||node.right == null)
                deque.offerLast(node);
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }

    }

    public int insert(int v) {

        TreeNode node = deque.peekFirst();
        deque.offerLast(new TreeNode(v));
        if (node.left == null )
            node.left = deque.peekLast();
        else {
            node.right = deque.peekLast();
            deque.pollFirst();
        }
        return node.val;

    }

    public TreeNode get_root() {
        return root;
    }
}
