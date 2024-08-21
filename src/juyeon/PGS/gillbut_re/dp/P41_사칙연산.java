package juyeon.PGS.gillbut_re.dp;

public class P41_사칙연산 {
    public static void main(String[] args) {
        P41_사칙연산 p41 = new P41_사칙연산();

        System.out.println(p41.solution(new String[]{"1", "-", "3", "+", "5", "-", "8"})); // 1
        System.out.println(p41.solution(new String[]{"5", "-", "3", "+", "1", "+", "2", "-", "4"})); // 3
    }

    public int solution(String arr[]) {
        // 피연산자 개수
        int n = (arr.length + 1) / 2;

        int[][] max = new int[n][n];
        int[][] min = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    max[i][i] = Integer.parseInt(arr[i * 2]);
                    min[i][i] = Integer.parseInt(arr[i * 2]);
                } else {
                    max[i][j] = Integer.MIN_VALUE;
                    min[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int op = 1; op < n; op++) {
            for (int i = 0; i < n - op; i++) {
                int j = i + op;

                for (int k = i; k < j; k++) {
                    String operator = arr[k * 2 + 1];
                    if (operator.equals("+")) {
                        max[i][j] = Math.max(max[i][j], max[i][k] + max[k + 1][j]);
                        min[i][j] = Math.min(min[i][j], min[i][k] + min[k + 1][j]);
                    } else if (operator.equals("-")) {
                        max[i][j] = Math.max(max[i][j], max[i][k] - min[k + 1][j]);
                        min[i][j] = Math.min(min[i][j], min[i][k] - max[k + 1][j]);
                    }
                }
            }
        }

        return max[0][n - 1];
    }
}
