package juyeon.PGS.drill.lv3;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PGS_가장_먼_노드 {
    @Test
    public void test() {
        PGS_가장_먼_노드 pgs_가장_먼_노드 = new PGS_가장_먼_노드();

        int result = pgs_가장_먼_노드.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
        assertEquals(3, result);
    }

    boolean[] visited;

    public int solution(int n, int[][] edge) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        visited = new boolean[n + 1];

        // 그래프 초기화
        for (int[] arr : edge) {
            int v1 = arr[0];
            int v2 = arr[1];

            graph.putIfAbsent(v1, new ArrayList<>());
            graph.putIfAbsent(v2, new ArrayList<>());

            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        return BFS(n, graph);
    }

    private int BFS(int n, Map<Integer, List<Integer>> graph) {
        int[] dist = new int[n + 1];

        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        visited[1] = true;
        dist[1] = 0;

        while (!q.isEmpty()) {
            int e = q.poll();

            for (int i = 0; i < graph.get(e).size(); i++) {
                int v = graph.get(e).get(i);

                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                    dist[v] = dist[e] + 1;
                }
            }
        }

        int max = Arrays.stream(dist).max().getAsInt();

        int answer = 0;

        for (int i : dist) {
            if (i == max) answer++;
        }

        return answer;
    }
}
