package juyeon.PGS.gilbut.kakao;

public class P69_양과_늑대 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{0,0,1,1,1,0,1,0,1,0,1,1}, new int[][] {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}})); // 5
//        System.out.println(solution(new int[]{0,1,0,1,1,0,1,0,0,1,0}, new int[][]{{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}})); // 5
    }

    private static int max = 0;
    private static int[] Info;
    private static int[][] Edges;

    private static int solution(int[] info, int[][] edges) {
        Info = info;
        Edges = edges;

        boolean[] visited = new boolean[info.length];

        DFS(0, visited, 0, 0);

        return max;
    }

    private static void DFS(int idx, boolean[] visited, int sheep, int wolf) {
        visited[idx] = true;

        if (Info[idx] == 0) {
            sheep++;
            if (sheep > max) max = sheep;
        } else wolf++;

        if (sheep > wolf) {
            for (int[] Edge : Edges) {
                int n = Edge[0];
                int m = Edge[1];
                if (visited[n] && !visited[m]) DFS(m, visited, sheep, wolf);
            }
        }

        visited[idx] = false;
    }
}
