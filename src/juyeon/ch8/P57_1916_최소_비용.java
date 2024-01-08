package juyeon.ch8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int idx;
    int cost;

    public Edge(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return (this.cost > o.cost ? 1 : -1);
    }
}

public class P57_1916_최소_비용 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] arr = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        int[] fee = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            fee[i] = Integer.MAX_VALUE;
        }

        boolean[] visited = new boolean[N + 1];

        StringTokenizer st;

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[s].add(new Edge(e, c));
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        fee[start] = 0;

        PriorityQueue<Edge> q = new PriorityQueue<>();

        q.add(new Edge(start, 0));

        while (!q.isEmpty()) {
            Edge current = q.poll();

            if (visited[current.idx]) continue;
            visited[current.idx] = true;

            for (int i = 0; i < arr[current.idx].size(); i++) {
                Edge next = arr[current.idx].get(i);

                if (fee[next.idx] > fee[current.idx] + next.cost) {
                    fee[next.idx] = fee[current.idx] + next.cost;

                    q.add(new Edge(next.idx, fee[next.idx]));
                }
            }

        }

        System.out.println(fee[end]);

    }
}
