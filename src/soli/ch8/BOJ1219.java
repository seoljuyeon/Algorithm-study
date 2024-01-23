package soli.ch8;

import doitproblems.ch8_graph.P60_1219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 벨만 포드
public class BOJ1219 implements P60_1219 {

    static int N, M;

    static int A, B;

    static ArrayList<Edge>[] edges;

    static int[] cost;

    static int[] profit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N개의 도시 (도시 번호 0-N)
        N = Integer.parseInt(st.nextToken());

        // A도시에서 B도시로 여행
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        // 교통수단 개수 M
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList[M+1];

        cost = new int[N+1];
        for(int i = 1 ; i<=N ;i++) {
            cost[i] = Integer.MAX_VALUE;
        }

        // 시작, 끝, 가격
        for(int i = 1 ; i <= M ; i++) {
            st = new StringTokenizer(br.readLine());

            edges[i] = new ArrayList<>();

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int v_cost = Integer.parseInt(st.nextToken());

            edges[i].add(new Edge(start, end, v_cost));
        }

        // 도시별 이득 정보를 저장할 배열
        profit = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            profit[i] = Integer.parseInt(st.nextToken());
        }

        cost[A] = profit[A]; // 시작 도시의 초기 이득

        // N-1 만큼 반복
        for(int i = 1 ; i < N ; i++) {
            for(int j = 1 ; j <= M ; j++) {
                for(Edge edge : edges[j]) {
                    if(cost[edge.from] != Integer.MAX_VALUE
                            && cost[edge.to] > cost[edge.from] + edge.value ) {
                        cost[edge.to] = cost[edge.from] + edge.value;
                    }
                }
            }
        }

        // 도시에서 벌 수 있는 돈의 최대값
        // 돈 액수의 최댓값 출력
        // 도시 도착이 불가하면 "gg"
        // 도착했을 때 무한히 가지고 있으면 "Gee"
        boolean minusCycle = false;
        for(int i = 1 ; i <= M ; i++) {
            for(Edge edge : edges[i]) {
                if(cost[edge.from] != Integer.MAX_VALUE
                        && cost[edge.to] > cost[edge.from] + edge.value) {
                    minusCycle = true;
                    break;
                }
            }
        }

        if(minusCycle) {
            System.out.println("Gee");
        } else if (cost[B] == Integer.MAX_VALUE) {
            System.out.println("gg");
        } else {
            System.out.println(cost[B]);
        }
    }

    static class Edge {
        int from;   // 출발
        int to;     // 도착
        int value;  // 비용

        public Edge(int from, int to, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }
    }
}