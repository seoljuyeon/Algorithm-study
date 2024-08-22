package juyeon.PGS.gillbut_re.dp;

public class P40_등굣길_2 {
    public static void main(String[] args) {
        P40_등굣길_2 p40 = new P40_등굣길_2();

        System.out.println(p40.solution(4, 3, new int[][]{{2, 2}})); // 4
    }

    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = 1;

        for (int[] pud : puddles)
            dp[pud[0]][pud[1]] = -1;

        int mod = 1000000007;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (dp[i][j] == -1 || (i == 1 && j == 1)) continue;

                // 왼 -> 오
                if (dp[i][j - 1] != -1) dp[i][j] += dp[i][j - 1] % mod;

                // 위 -> 아래
                if (dp[i - 1][j] != -1) dp[i][j] += dp[i - 1][j] % mod;
            }
        }

        return dp[m][n] % mod;
    }
}
