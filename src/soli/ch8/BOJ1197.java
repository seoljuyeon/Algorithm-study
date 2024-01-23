package soli.ch8;

import doitproblems.ch8_graph.P64_1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1197 implements P64_1197 {

    static int V, E;
    static int[] parent;
    static PriorityQueue<Edge> Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        Q = new PriorityQueue<>();

        parent = new int[V+1];
        for(int i = 1; i<= V ; i++) {
            parent[i] = i;
        }

        for(int i = 0 ; i < E ;i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            Q.add(new Edge(A, B, C));
        }

        int result = 0;
        while(!Q.isEmpty()) {
            Edge edge = Q.poll();

            if(find(edge.start) != find(edge.end)) {
                union(edge.start, edge.end);
                result += edge.value;
            }
        }

        System.out.println(result);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            parent[y] = x;
        }
    }

    static int find(int x) {
        if(x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static class Edge implements Comparable<soli.ch8.Edge> {
        int start;
        int end;
        int value;

        public Edge(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(soli.ch8.Edge o) {
            return this.value - o.value;
        }
    }
}

