package juyeon.PGS.gilbut.implementation;

import java.util.LinkedList;
import java.util.Queue;

public class P61_게임_맵_최단거리_2 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}})); // 11
        System.out.println(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}})); // -1
    }

    static boolean[][] visited;
    static int n, m;

    private static int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;

        visited = new boolean[n][m];

        return BFS(0, 0, maps);
    }

    private static int BFS(int x, int y, int[][] maps) {
        Queue<int[]> q = new LinkedList<>();

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        q.offer(new int[]{x, y, 1});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] point = q.poll();

            if (point[0] == n - 1 && point[1] == m - 1) return point[2];

            for (int k = 0; k < 4; k++) {
                int nx = point[0] + dx[k];
                int ny = point[1] + dy[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, point[2] + 1});
                }
            }
        }

        return -1;
    }
}
