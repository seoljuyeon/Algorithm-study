package juyeon.PGS.gillbut_re.dataStructure;

public class P47_순위_2 {
    public static void main(String[] args) {
        P47_순위_2 p47 = new P47_순위_2();

        System.out.println(p47.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}})); // 2
    }

    public int solution(int n, int[][] results) {
        int answer = 0;

        int[][] graph = new int[n + 1][n + 1];

        for (int[] res : results) {
            graph[res[0]][res[1]] = 1;
            graph[res[1]][res[0]] = -1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    }

                    if (graph[i][k] == -1 && graph[k][j] == -1) {
                        graph[i][j] = -1;
                        graph[j][i] = 1;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] != 0) count++;
            }
            if (count == n - 1) answer++;
        }

        return answer;
    }
}