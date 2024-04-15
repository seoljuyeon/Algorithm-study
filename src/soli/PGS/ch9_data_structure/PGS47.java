package soli.PGS.ch9_data_structure;

import java.util.*;

public class PGS47 {

    public int solution(int n, int[][] results) {

        int[][] graph = new int[n+1][n+1];
        for(int[] result : results) {
            graph[result[0]][result[1]] = 1;
            graph[result[1]][result[0]] = -1;
        }

        // 시작
        for(int i = 1 ; i <= n ; i++) {
            // 끝
            for(int j = 1; j <= n ; j++) {
                // 거쳐가는 지점
                for(int k = 1 ; k <= n ; k++) {
                    if(graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    }

                    if(graph[i][k] == -1 && graph[k][j] == -1) {
                        graph[i][j] = -1;
                        graph[j][i] = 1;
                    }
                }
            }
        }

        int answer = 0;

        for(int i = 0 ; i <= n ; i++) {
            int count = 0;
            for(int j = 0 ; j <= n ; j++) {
                if(graph[i][j] != 0 ) count++;
            } if(count == n-1) answer++;
        }
        return answer;
    }
    public static void main(String[] args) {

        PGS47 pgs47 = new PGS47();

        System.out.println("TEST CASE : " + pgs47.solution(5, new int[][]{{4,3}, {4,2}, {3,2}, {1,2}, {2,5}}));
    }
}
