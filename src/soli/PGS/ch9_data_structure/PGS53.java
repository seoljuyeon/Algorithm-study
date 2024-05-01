package soli.PGS.ch9_data_structure;
import java.util.*;

public class PGS53 {


    static List<List<Node>> A = new ArrayList<>();
    static boolean[] visited;

    public int solution(int n, int[][] costs) {

        int answer = 0;

        visited = new boolean[n];

        for(int i = 0 ; i < n ; i++) {
            A.add(new ArrayList<>());

        }

        for(int i = 0 ; i < costs.length ; i++) {
            int from = costs[i][0];
            int to = costs[i][1];
            int value = costs[i][2];
            A.get(from).add(new Node(to, value));
            A.get(to).add(new Node(from, value));
            // 양방향이니까 둘 다 넣어줌
        }

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(0, 0));
        while(!q.isEmpty()) {
            Node now = q.poll();

            if(!visited[now.node]) {
                visited[now.node] = true;
                answer += now.value;
            }

            for(int i = 0 ; i < costs.length ; i++) {
                int next = A.get(now.node).get(i).node;
                int value = A.get(now.node).get(i).value;

                if(!visited[next]) {
                    q.add(new Node(next, value));
                }
            }
            return answer;

        }



        return answer;
    }

    public class Node implements Comparable<Node> {
        int node;
        int value;

        public Node(int node, int value) {
            this.node = node;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }

    }

    public static void main(String[] args) {

    }
}
