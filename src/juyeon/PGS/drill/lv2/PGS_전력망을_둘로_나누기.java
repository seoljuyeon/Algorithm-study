package juyeon.PGS.drill.lv2;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PGS_전력망을_둘로_나누기 {

    int answer;
    boolean[] visited;

    public int solution(int n, int[][] wires) {
        answer = Integer.MAX_VALUE;

        Map<Integer, List<Integer>> graph = new HashMap<>();

        // 그래프 초기화
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];

            graph.putIfAbsent(v1, new ArrayList<>());
            graph.putIfAbsent(v2, new ArrayList<>());

            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        // 전선 하나씩 자르기
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];

            // remove(v2) 로 하면 idx로 인식할까바 Integer.valueOf() 씀
            graph.get(v1).remove(Integer.valueOf(v2));
            graph.get(v2).remove(Integer.valueOf(v1));

            visited = new boolean[n + 1];

            int count = DFS(v1, visited, graph);
            int diff = Math.abs((n - count) - count);

            answer = Math.min(answer, diff);

            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        return answer;
    }

    private int DFS(int idx, boolean[] visited, Map<Integer, List<Integer>> graph) {
        visited[idx] = true;
        int count = 1;

        for (int neighbor : graph.get(idx)) {
            if (!visited[neighbor]) {
                count += DFS(neighbor, visited, graph);
            }
        }

        return count;
    }

    @Test
    public void test1() {
        PGS_전력망을_둘로_나누기 pgs_전력망을_둘로_나누기 = new PGS_전력망을_둘로_나누기();
        int result = pgs_전력망을_둘로_나누기.solution(9, new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}});
        assertEquals(3, result);
    }

    @Test
    public void test2() {
        PGS_전력망을_둘로_나누기 pgs_전력망을_둘로_나누기 = new PGS_전력망을_둘로_나누기();
        int result = pgs_전력망을_둘로_나누기.solution(4, new int[][]{{1,2},{2,3},{3,4}});
        assertEquals(0, result);
    }

    @Test
    public void test3() {
        PGS_전력망을_둘로_나누기 pgs_전력망을_둘로_나누기 = new PGS_전력망을_둘로_나누기();
        int result = pgs_전력망을_둘로_나누기.solution(7, new int[][]{{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}});
        assertEquals(1, result);
    }
}
