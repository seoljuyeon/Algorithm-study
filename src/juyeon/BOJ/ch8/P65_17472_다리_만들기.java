package juyeon.BOJ.ch8;

import doitproblems.ch8_graph.P65_17472;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Bridge implements Comparable<Bridge> {
    int x;
    int y;
    int len;

    public Bridge(int x, int y, int len) {
        this.x = x;
        this.y = y;
        this.len = len;
    }

    @Override
    public int compareTo(Bridge o) {
        return this.len - o.len;
    }
}

public class P65_17472_다리_만들기 implements P65_17472 {

    private static int N, M;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int[][] map;
    private static boolean[][] visited;
    private static PriorityQueue<Bridge> pq;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int islandNum = 1;
        visited = new boolean[N + 1][M + 1];

        // 섬 인덱싱
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    visited[i][j] = true;
                    indexing(i, j, islandNum);
                    islandNum++;
                }
            }
        }

        // 연결 가능한 다리 완탐
        pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] != 0) makeBridge(i, j, map[i][j]);
            }
        }

        // 다리 길이 최솟값 구하기
        parent = new int[islandNum + 1];

        for (int i = 1; i <= islandNum; i++) {
            parent[i] = i;
        }

        int sum = 0;

        int size = pq.size();

        for (int i = 1; i <= size; i++) {
            Bridge b = pq.poll();

            int from = b.x;
            int to = b.y;
            int len = b.len;

            if (find(from) != find(to)) {
                union(from, to);
                sum += len;
            }
        }

        System.out.println(sum == 0 ? -1 : sum);


    }

    // 섬 인덱싱
    private static void indexing(int x, int y, int num) {
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(x, y));
        map[x][y] = num;
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();
            int px = now.x;
            int py = now.y;

            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                // 맵 경계 안에 있는지 유효성 검사
                if (nx < 1 || ny < 1 || nx > N || ny > M || visited[nx][ny]) continue;

                if (map[nx][ny] == 1) {
                    map[nx][ny] = num;
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny));
                }
            }
        }

    }

    // 길이 2 이상인 다리 만들
    private static void makeBridge(int x, int y, int idx) {
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[N + 1][M + 1];

        for (int d = 0; d < 4; d++) {
            q.add(new int[] {x, y, 0});
            visited[x][y] = true;

            while (!q.isEmpty()) {
                int[] now = q.poll();
                int px = now[0];
                int py = now[1];
                int plen = now[2];

                int nx = px + dx[d];
                int ny = py + dy[d];

                if (nx < 1 || ny < 1 || nx > N || ny > M || visited[nx][ny]) continue;

                if (map[nx][ny] != idx) {
                    if (map[nx][ny] != 0) {
                        int from = idx;
                        int to = map[nx][ny];

                        if (plen > 1) {
                            pq.add(new Bridge(from, to, plen));
                            break;
                        }

                    } else {
                        visited[nx][ny] = true;
                        q.add(new int[] {nx, ny, plen + 1});
                    }
                }
            }
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    private static int find(int n) {
        if (n == parent[n]) {
            return n;
        } else {
            return parent[n] = find(parent[n]);
        }
    }

}


/**
 * 반례
 *
 * 10 8
 * 0 0 1 1 1 1 1 0
 * 1 1 1 1 1 1 0 1
 * 0 0 0 1 0 1 0 0
 * 1 1 0 1 1 0 1 1
 * 0 0 1 1 0 1 1 0
 * 0 1 0 0 0 0 0 0
 * 1 1 1 1 0 0 1 0
 * 1 0 0 1 1 1 0 0
 * 1 1 0 0 0 1 1 1
 * 1 1 1 0 0 1 0 1
 *
 *
 * 해결 못 함!! -1 나와야 댐 ㅋㅋ
 * **/