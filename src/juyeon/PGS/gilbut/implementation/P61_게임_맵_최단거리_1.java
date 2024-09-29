package juyeon.PGS.gilbut.implementation;

import java.util.*;

class Point {
    public int x, y, count;

    public Point(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

public class P61_게임_맵_최단거리_1 {
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
        Queue<Point> q = new LinkedList<>();

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        q.offer(new Point(x, y, 1));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Point point = q.poll();

            if (point.x == n - 1 && point.y == m - 1) return point.count;

            for (int k = 0; k < 4; k++) {
                int nx = point.x + dx[k];
                int ny = point.y + dy[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny, point.count + 1));
                }
            }
        }

        return -1;
    }

}
