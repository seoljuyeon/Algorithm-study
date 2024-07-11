package soli.ELC;

import java.util.*;
import java.io.*;

class ELC4_트리위의게임 {
    static ArrayList<Integer>[] tree;
    static int[] answer;
    static int[] depth;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        answer = new int[N + 1];
        depth = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree[u].add(v);
            tree[v].add(u);
        }

        bfs(1);


        for (int i = 1; i <= N; i++) {
            if (depth[i] % 2 == 0) {
                answer[i] = 1; // 선공이 승리
            } else {
                answer[i] = 0; // 후공이 승리
            }
        }

        // 결과 출력
        for (int i = 1; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        depth[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int child : tree[node]) {
                if (!visited[child]) {
                    visited[child] = true;
                    depth[child] = depth[node] + 1;
                    queue.add(child);
                }
            }
        }
    }
}