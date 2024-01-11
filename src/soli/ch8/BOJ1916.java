package soli.ch8;

import doitproblems.ch8_graph.P57_1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1916 implements P57_1916 {

    static int N, M;
    static ArrayList<Node>[] arr;
    static int[] costArray; // 비용 저장 배열
    static boolean[] visited; // 방문 확인 배열
    static PriorityQueue<Node> Q = new PriorityQueue<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 도시 개수
        N = Integer.parseInt(br.readLine());

        // 버스 대수
        M = Integer.parseInt(br.readLine());

        arr = new ArrayList[N+1];
        // A 초기화
        for(int i = 1; i <= N ; i++) {
            arr[i] = new ArrayList<>();
        }

        costArray = new int[N+1];
        visited = new boolean[N+1];
        for(int i = 1 ; i <= N ; i++) {
            costArray[i] = Integer.MAX_VALUE;   // 최대값 넣어놓기
            visited[i] = false;
        }

        // 버스 정보만큼 입력
        for(int i = 1 ; i <= M ; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            // 버스 정보 출발
            int A = Integer.parseInt(st.nextToken());
            // 버스 정보 도착
            int B = Integer.parseInt(st.nextToken());
            // 버스 비용
            int cost = Integer.parseInt(st.nextToken());

            // 출발 arr 에 (도착정보, 비용) 으로 저장
            arr[A].add(new Node(B, cost));
        }

        // 출발 도착
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Q = new PriorityQueue<>();

        Q.add(new Node(start, 0));
        costArray[start] = 0;

        while(!Q.isEmpty()) {
            Node current = Q.poll();
            int current_to = current.to;

            if(visited[current_to]) {
                continue;
            }
            visited[current_to] = true;

            if(current_to == end) {
                System.out.println(costArray[end]);
                break;
                // return 문보다
            }

            for(Node next : arr[current_to]) {
                int next_to = next.to;
                int next_value = next.value;

                // 만약에 지금 저장되어있는 비용이 (지금까지 + arr에 저장된 노드 비용) 더 크면
                if(!visited[next_to] && costArray[next_to] > costArray[current_to] + next_value ) {
                    // 두 개 바꾸기
                    costArray[next_to] = costArray[current_to] + next_value;

                    Q.add(new Node(next_to, costArray[next_to]));
                }
            }
        }
//        System.out.println(costArray[end]);
    }

    static class Node implements Comparable<Node> {
        int to ;
        int value;

        public Node(int to, int value) {
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.value, o.value);
        }
    }
}
