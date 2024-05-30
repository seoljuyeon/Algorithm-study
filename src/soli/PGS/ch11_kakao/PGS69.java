package soli.PGS.ch11_kakao;

public class PGS69 {

    static int max = 1;
    static int[] gInfo;
    static int[][] gEdges;

    public int solution(int[] info, int[][] edges){

        gInfo = info;
        gEdges = edges;

        boolean[] visited = new boolean[info.length];

        int sheep = 0;
        int wolf = 0;

        return 0;
    }

    public void dfs(int idx, boolean[] visited, int sheep, int wolf) {
        visited[idx] = true;

        // 만약에 0이 나오면 양 ++, 1이 나오면 wolf++
        if(gInfo[0] == 0) {
            sheep++;
            // 만약에 max 보다 지금 sheep이 많으면 max 바꾸기
            if(max < sheep) {
                max = sheep;
            }
        } else {
            wolf++;
        }

        // 만약에 늑대가 양보다 같거나 많으면 다시
        if(wolf >= sheep) {
            visited[idx] = false;
            return;
        }

        for(int[] edge : gEdges) {
            if(visited[edge[0]] && !visited[edge[1]]) {
                dfs(edge[1], visited, sheep, wolf);
            }
        }
        visited[idx] = false;
    }

    public static void main(String[] args) {
        PGS69 pgs69 = new PGS69();

        System.out.println(pgs69.solution(new int[]{0,0,1,1,1,0,1,0,1,0,1,1}, new int[][]{{0,1}, {1,2}, {1,4}, {0,8}, {8,7}, {9,10}, {9,11}, {4,3}, {6,5}, {4,6}, {8,9}}));
        System.out.println(pgs69.solution(new int[]{0,1,0,1,1,0,1,0,0,1,0}, new int[][]{{0,1}, {0,2}, {1,3}, {1,4}, {2,5}, {2,6}, {3,7}, {4,8}, {6,9}, {9,10}}));
    }
}
