package juyeon.PGS.drill.lv3;

import java.util.Arrays;

public class PGS_정수_삼각형 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}})); // 30
    }

    private static int solution(int[][] triangle) {
        int len = triangle.length;

        for (int i =1; i < len; i++) {
            triangle[i][0] += triangle[i-1][0];
            triangle[i][i] += triangle[i-1][i-1];
        }

        for (int i = 2; i < len; i++) {
            for (int j = 1; j < i; j++) {
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
            }
        }

        return Arrays.stream(triangle[len - 1]).max().getAsInt();

        // -----------------------------------------

//        int len = triangle.length;
//        for (int i = len - 2; i >= 0; i--) {
//            for (int j = 0; j < triangle[i].length; j++) {
//                triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
//            }
//        }
//
//        return triangle[0][0];

        // -----------------------------------------

        // 머가 틀렸는지 모르겠음 ㅋㅋ ㅠ
//        int answer = 0;
//        int len = triangle.length;
//
//        int[][] dp = new int[len][len];
//
//        dp[0][0] = triangle[0][0];
//
//        for (int i = 1; i < len; i++) {
//            dp[i][0] = dp[i - 1][0] + triangle[i][0];
//        }
//
//        for (int i = 1; i < len; i++) {
//            for (int j = 1; j < i; j++) {
//                dp[i][j] = Math.max(dp[i - 1][j - 1] + triangle[i][j], dp[i - 1][j] + +triangle[i][j]);
//
//            }
//        }
//
//        for (int i = 0; i < len; i++) {
//            answer = Math.max(answer, dp[len - 1][i]);
//        }
//
//        return answer;
    }
}
