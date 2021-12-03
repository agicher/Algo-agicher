package com.TreeTheme;

import com.TreeTheme.com.TreeNode;

/**
 * @author agicher
 * @date 2021/12/1 21:45
 * {@link = https://leetcode-cn.com/problems/3Etpl5/ }
 */
public class Offer_2_49 {
    // 本质仍为 遍历 记录路径 ->  string -> int



    public static int sumNumbers(TreeNode root) {
        StringBuilder path = new StringBuilder();
        return solve1(path,root,0);

    }

    private static int solve(StringBuilder path, TreeNode root, int ans) {
        if (root == null){
            return 0;
        }
        path.append(root.val);
        if (root.left == null && root.right == null)
            ans += Integer.valueOf(path.toString());

        if (root.left != null )
            ans = solve(path, root.left, ans);
        if (root.right != null)
            ans = solve(path, root.right, ans);
        path.deleteCharAt(path.length() - 1);
        return ans;
    }


    private static int solve1(StringBuilder path, TreeNode root, int ans){
        if (root == null)
            return 0;
        path.append(root.val);
        if (root.left == null && root.right == null)
            ans += Integer.valueOf(path.toString());

        if (root.left != null )
            ans = solve1(path, root.left, ans);
        if (root.right != null)
            ans = solve1(path, root.right, ans);
        path.deleteCharAt(path.length() - 1);
        return ans;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        System.out.println(sumNumbers(root));
    }
}
