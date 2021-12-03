package com.dpTheme;

/**
 * @author agicher
 * @date 2021/11/30 9:38
 */
public class fib {

    public static int solution( int N){
        if (N == 1 || N == 2) return 1;
        return solution(N-1) + solution(N-2);
    }

    public static int solution_memo(int N){
        int[] memo = new int[N+1];
        return solve(memo, N);
    }

    private static int solve(int[] memo, int n) {
        if (n == 1 || n == 2) return 1;
        if (memo[n] != 0) return memo[n];
        return solve(memo, n-1) +solve(memo, n-2);
    }


    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution_memo(10));
    }
}
