package juyeon.PGS.drill.lv3;

public class PGS_네트워크 {
    public static void main(String[] args) {
        System.out.println(solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}})); // 2
    }

    private static boolean[] visited;

    private static int solution(int n, int[][] computers) {
        int count = 0;

        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                DFS(i, computers);
            }
        }

        return count;
    }

    private static void DFS(int i, int[][] computers) {
        visited[i] = true;

        for (int j = 0; j < computers.length; j++) {
            if (!visited[j] && computers[i][j] == 1) {
                DFS(j, computers);
            }
        }

    }
}
