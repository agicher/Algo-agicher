package com.dp;

import com.sun.javafx.css.PseudoClassState;
import com.sun.org.apache.regexp.internal.RE;

/**
 * @author agicher
 * @date 2021/12/3 9:37
 * <p>
 * {@link = https://leetcode-cn.com/problems/coin-change/}
 * 凑零钱
 */
public class p322 {
    // 暴力递归
    public static int coinChange(int[] coins, int amount) {
        return solve(coins, amount);
    }

    private static int solve(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        int res = Integer.MAX_VALUE;
        for (int coin : coins){
            int sub_problem = solve(coins,amount -coin);
            if (sub_problem < 0) continue;
            res = Math.min(res,sub_problem + 1);
        }

        if (res != Integer.MAX_VALUE)
            return res;
        else
            return -1;
    }

    private static int coinChange_dp(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for ( int i = 0; i < dp.length; i++){
            for ( int coin : coins){
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }

        return dp[amount] == amount + 1 ? - 1 : dp[amount];
    }


    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{5, 2, 10}, 11));
    }
}
