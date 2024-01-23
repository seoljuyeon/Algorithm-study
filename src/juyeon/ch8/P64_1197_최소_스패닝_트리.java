package juyeon.ch8;

import doitproblems.ch8_graph.P64_1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge64 implements Comparable<Edge64> {
    int s;
    int e;
    int w;

    public Edge64(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }

    @Override
    public int compareTo(Edge64 o) {
        return this.w - o.w;
    }
}

public class P64_1197_최소_스패닝_트리 implements P64_1197 {

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        PriorityQueue<Edge64> pq = new PriorityQueue<>();

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            pq.add(new Edge64(A, B, C));
        }

        int count = 0;
        int sum = 0;

        while (count < V - 1) {
            Edge64 now = pq.poll();
            int s = now.s;
            int e = now.e;
            int w = now.w;

            if (find(s) != find(e)) {
                union(s, e);
                count++;
                sum += w;
            }
        }

        System.out.println(sum);
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
