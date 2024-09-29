package soli.PGS2.ch9_data_structure;

import soli.PGS.ch9_data_structure.PGS47;

public class PGS47_순위 {
    public int solution(int n, int[][] results) {

        int[][] arr = new int[n][n];

        for(int[] edge : results) {
            arr[edge[0] - 1][edge[1] - 1] = 1;
            arr[edge[1] - 1][edge[0] - 1] = -1;
        }

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                for(int k = 0 ; k < n ; k++) {
                    if(arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                        arr[j][i] = -1;
                    }
                    if(arr[i][k] == -1 && arr[k][j] == -1) {
                        arr[i][j] = -1;
                        arr[j][i] = 1;
                    }
                }
            }
        }
        int answer = 0;

        for(int i = 0 ; i < n ; i++) {
            int count = 0 ;
            for(int j = 0 ; j < n ; j++) {
                if(arr[i][j] != 0) count++;
            }
            if(count == n-1) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        PGS47_순위 pgs47 = new PGS47_순위();

        System.out.println("TEST CASE : " + pgs47.solution(5, new int[][]{{4,3}, {4,2}, {3,2}, {1,2}, {2,5}}));
    }

}
