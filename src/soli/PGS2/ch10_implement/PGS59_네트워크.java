package soli.PGS2.ch10_implement;

public class PGS59_네트워크 {


    static boolean[] visited;

    public static int solution(int n, int[][] computers) {

        visited = new boolean[n];

        int answer = 0;

        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                dfs(i, computers, visited, n);
                answer++;
            }
        }

        return answer;
    }

    public static void dfs(int node, int[][] computers, boolean[] visited, int n) {

        visited[node] = true;

        for(int i = 0 ; i < n ; i++) {
            if(computers[node][i] == 1 && !visited[i]) {
                visited[i] = true;

                dfs(i, computers, visited, n);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}})); // 2
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}})); // 1
    }
}
