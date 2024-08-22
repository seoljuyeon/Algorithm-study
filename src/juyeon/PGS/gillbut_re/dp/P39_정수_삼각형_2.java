package juyeon.PGS.gillbut_re.dp;

public class P39_정수_삼각형_2 {
    public static void main(String[] args) {
        P39_정수_삼각형_2 p39 = new P39_정수_삼각형_2();

        System.out.println(p39.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}})); // 30
    }

    public int solution(int[][] triangle) {
        int len = triangle.length;

        for (int i = len - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                triangle[i - 1][j] += Math.max(triangle[i][j], triangle[i][j + 1]);
            }
        }

        return triangle[0][0];
    }
}
