package juyeon.PGS.drill.lv2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PGS_피로도 {
    @Test
    public void test() {
        PGS_피로도 pgs_피로도 = new PGS_피로도();
        int result = pgs_피로도.solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}});
        assertEquals(3, result);
    }

    int count;
    boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        count = 0;
        visited = new boolean[dungeons.length];
        DFS(0, k, dungeons);
        return count;
    }

    private void DFS(int depth, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                DFS(depth + 1, k - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }

        count = Math.max(count, depth);
    }
}
