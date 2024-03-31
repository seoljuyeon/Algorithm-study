package juyeon.PGS.gilbut.dp;

import java.util.Arrays;

public class P39_정수_삼각형 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}})); // 30
    }

    private static int solution(int[][] triangle) {
        int len = triangle.length;

//        // 위 -> 아래
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    triangle[i][j] += triangle[i - 1][j];
                } else if (j == i) {
                    triangle[i][j] += triangle[i - 1][j - 1];
                } else {
                    triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }
            }
        }

        return Arrays.stream(triangle[len - 1]).max().getAsInt();

//        // 아래 -> 위
//        for (int i = len - 1; i > 0; i--) {
//            for (int j = 0; j < i; j++) {
//                triangle[i - 1][j] += Math.max(triangle[i][j], triangle[i][j + 1]);
//            }
//        }
//
//        return triangle[0][0];
    }
}
