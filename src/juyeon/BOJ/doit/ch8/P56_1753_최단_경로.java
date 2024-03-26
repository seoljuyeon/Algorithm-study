package juyeon.BOJ.doit.ch8;

import doitproblems.ch8_graph.P56_1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int idx;
    int cost;

    public Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

public class P56_1753_최단_경로 implements P56_1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        ArrayList<Node>[] arr = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            arr[i] = new ArrayList<>();
        }

        int[] distance = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        // 시작점 초기화
        distance[K] = 0;

        boolean[] visited = new boolean[V + 1];

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arr[u].add(new Node(v, w));
        }

        PriorityQueue<Node> q = new PriorityQueue<>();

        q.add(new Node(K, 0));

        while (!q.isEmpty()) {
            Node current = q.poll();

            if (visited[current.idx]) continue;

            visited[current.idx] = true;

            for (int i = 0; i < arr[current.idx].size(); i++) {
                Node next = arr[current.idx].get(i);

                if (distance[next.idx] > distance[current.idx] + next.cost) {
                    distance[next.idx] = distance[current.idx] + next.cost;
                    q.add(new Node(next.idx, distance[next.idx]));
                }
            }

        }

        for (int i = 1; i <= V; i++) {
            if (visited[i]) {
                System.out.println(distance[i]);
            } else {
                System.out.println("INF");
            }
        }

    }
}

// 5 6
// 1
// 5 1 1
// 1 2 2
// 1 3 3
// 2 3 4
// 2 4 5
// 3 4 6

// 0
// 2
// 3
// 7
// INF