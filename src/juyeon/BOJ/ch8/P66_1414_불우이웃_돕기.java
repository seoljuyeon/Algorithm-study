package juyeon.BOJ.ch8;

import doitproblems.ch8_graph.P66_1414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Edge66 implements Comparable<Edge66> {
    int s;
    int e;
    int w;

    public Edge66(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }

    @Override
    public int compareTo(Edge66 o) {
        return this.w - o.w;
    }
}

public class P66_1414_불우이웃_돕기 implements P66_1414 {

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        PriorityQueue<Edge66> pq = new PriorityQueue<>();

        int sum = 0;

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();

            for (int j = 1; j <= N; j++) {
                int k = (int)str.charAt(j - 1);

                if (k >= 97) k = k - 96;
                else if (k == 48) k = 0;
                else k = k - 38;

                if (k != 0) pq.add(new Edge66(i, j, k));
                sum += k;
            }
        }

        int count = 0;


        while (!pq.isEmpty()) {
            if (count == N - 1) break;

            Edge66 now = pq.poll();
            int s = now.s;
            int e = now.e;
            int w = now.w;

            if (find(s) != find(e)) {
                union(s, e);
                count++;
                sum -= w;
            }
        }

        if (count < N - 1) System.out.println("-1");
        else System.out.println(sum);
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
