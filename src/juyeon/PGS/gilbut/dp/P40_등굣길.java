package juyeon.PGS.gilbut.dp;

public class P40_등굣길 {
    public static void main(String[] args) {
        System.out.println(solution(4, 3, new int[][]{{2, 2}})); // 4
    }

    private static int solution(int m, int n, int[][] puddles) {
        int mod = 1000000007;
        int[][] dp = new int[m + 1][n + 1];

        dp[1][1] = 1;

        for (int[] puddle : puddles) {
            dp[puddle[0]][puddle[1]] = -1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (dp[i][j] == -1 || (i == 1 && j == 1)) continue;

                // 위에서 오는 경우
                if (i != 1 && dp[i - 1][j] != -1) dp[i][j] = (dp[i][j] + dp[i - 1][j]) % mod;

                // 왼쪽에서 오는 경우
                if (j != 1 && dp[i][j - 1] != -1) dp[i][j] = (dp[i][j] + dp[i][j - 1]) % mod;

            }
        }

        return dp[m][n];
    }
}
