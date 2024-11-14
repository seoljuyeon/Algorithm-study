package juyeon.PGS.drill.lv2;

public class PGS_피로도 {
    public static void main(String[] args) {
        PGS_피로도 pgs_피로도 = new PGS_피로도();

        System.out.println(pgs_피로도.solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}})); // 3
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
