package soli.ch8;

import doitproblems.ch8_graph.P59_11657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11657 implements P59_11657 {

    static int N, M;
    static ArrayList<Edge>[] edges;
    static long distance[]; // int로 하면 출력 초과남


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N개의 도시
        N = Integer.parseInt(st.nextToken());

        // M개의 버스
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList[M+1];
        distance = new long[N + 1];
        for(int i = 1 ; i <= N ; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[1] = 0;

        for(int i = 1 ; i <= M ; i++) {
            edges[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());

            // A 시작도시
            int A = Integer.parseInt(st.nextToken());
            // B 도착도시
            int B = Integer.parseInt(st.nextToken());
            // C 이동하는데 걸리는 시간
            int C = Integer.parseInt(st.nextToken());

            edges[i].add(new Edge(A, B, C));
        }

        // N-1 개만큼 반복
        for(int i = 1; i < N ; i++) {
            for(int j = 1 ; j <= M ; j++) {
                for(Edge edge : edges[j]) {
                    if(distance[edge.from] != Integer.MAX_VALUE
                            && distance[edge.to] > distance[edge.from] + edge.value ) {
                        distance[edge.to] = distance[edge.from] + edge.value;}
                }
            }
        }

        // C가 양수가 아닌 경우가 있다.
        // C==0일 때 순간이동
        // C < 0 일 떼 타임머신으로 되돌아감
        // 최단 시간을 구해라
        // 음수 사이클 체크
        boolean minusCycle = false;

        for(int i = 1; i <= M ; i++){
            for(Edge edge : edges[i]) {
                if(distance[edge.from] != Integer.MAX_VALUE
                        && distance[edge.to] > distance[edge.from] + edge.value) {
                    minusCycle = true;
                }
            }
        }

        // 만약에 무한히 오래전으로 되돌린다면 첫째줄 -1 출력
        // 그렇지 않다면 N-1 개에 걸쳐서 가장 빠른 시간을 순서대로 출력
        // 도시로 가는 경로가 없다면 -1 출력
        if(minusCycle) {    // 음수 사이클 있으면 -1
            System.out.println("-1");
        } else {
            // 알고리즘 시작이 1번 노드이기 때문에
            for(int i = 2 ; i <= N ; i++) {
                if(distance[i] == Integer.MAX_VALUE) {
                    System.out.println("-1");
                } else {
                    System.out.println(distance[i]);
                }
            }
        }
    }

    static class Edge {
        int from;   // 출발
        int to;     // 시작
        int value;  // 도착

        public Edge(int from, int to, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }
    }
}
