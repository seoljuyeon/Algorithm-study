package soli.ch8;

import doitproblems.ch8_graph.P56_1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1753 implements P56_1753 {

    static int V, E;
    static ArrayList<Node>[] A;
    static int[] distance;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        // 정점의 개수 V
        V = Integer.parseInt(st.nextToken());

        // 간선의 개수 E
        E = Integer.parseInt(st.nextToken());

        // 시작 정점의 번호 K
        int K = Integer.parseInt(br.readLine());

        A = new ArrayList[V+1];
        for(int i = 1 ; i <= V ; i++) {
            A[i] = new ArrayList<>();
        }

        distance = new int[V+1];
        visited = new boolean[V+1];
        for(int i = 1 ; i <= V ; i++){
            // 제일 큰 값 넣어놓고 비교 해야하기 때문에 넣어놓기
            distance[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        // 시작값은 0으로
        distance[K] = 0;

        for(int i = 0 ; i <= E ; i++) {
            // 간선을 나타내는 세 개의 정수 u,v,w
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            // 배열리스트에 노드 추가(어디로, 가중치)
            A[u].add(new Node(v, w));
        }

        PriorityQueue<Node> Q = new PriorityQueue<>();
        Q.add(new Node(K, 0));

        while(!Q.isEmpty()) {
            Node current = Q.poll();
            int current_to = current.to;
            int current_value = current.value;

            // 방문한 노드 다시 방문 안 하게 함
            if(visited[current_to]){
                continue;
            }

            // 방문하고 나면 visited true로 변경
            visited[current_to] = true;

            // 배열리스트의 current_to 사이즈만큼 방문해서 검사
            for(Node tmp : A[current_to]) {
                int next_to = tmp.to;
                int next_value = tmp.value;

                if(distance[next_to] > distance[current_to] + next_value) {
                    distance[next_to] = distance[current_to] + next_value;
                    Q.add(new Node(next_to, distance[next_to]));
                }
            }
        }

        for(int i = 1 ; i <= V ; i++) {
            if(distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }
            else {
                System.out.println(distance[i]);
            }
        }
    }

    static class Node implements Comparable<Node> {
        int to;
        int value;

        public Node(int to, int value) {
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            // 우선순위 큐 비교 -> 노드 끼리 비교
            return Integer.compare(this.value, o.value);
        }

    }
}
