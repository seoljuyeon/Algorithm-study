package soli.PGS.ch1_array;

import java.util.Arrays;

public class PGS1 {
    public static int[] solution(int n) {
        int[][] tri = new int[n][n];

        int x = -1;
        int y = 0;
        int num = 1;

        for(int i = 0 ; i < n ; i++) {
            for(int j = i ; j < n ; j++) {
                if(i % 3 == 0) {
                    x++;
                } else if(i % 3 == 1) {
                    y++;
                } else {
                    x--;
                    y--;
                }
                tri[x][y] = num++;
            }
        }

        int[] answer = new int[n * (n+1) / 2];
        int idx = 0;
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0; j <= i ; j++) {
                answer[idx++] = tri[i][j];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4)));
        System.out.println(Arrays.toString(solution(5)));
        System.out.println(Arrays.toString(solution(6)));
    }
}
