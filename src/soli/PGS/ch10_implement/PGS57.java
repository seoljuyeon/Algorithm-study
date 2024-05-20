package soli.PGS.ch10_implement;

public class PGS57 {

    public int solution(int n, int[][] computers){

        boolean[] visited = new boolean[n];

        int answer = 0;

        for(int i = 0; i < n ; i++) {
            if(!visited[i]){
                dfs(n, computers, i, visited);
                answer++;
            }
        }
        return answer;
    }

    public void dfs(int n, int[][] computers, int node , boolean[] visited) {
        visited[node] = true;

        for(int i = 0 ; i < n ; i++) {
            if(computers[node][i] == 1 && !visited[i]) {
                dfs(n, computers, node, visited);
            }
        }
    }

    public static void main(String[] args) {

    }

}
