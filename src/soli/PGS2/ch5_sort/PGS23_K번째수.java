package soli.PGS2.ch5_sort;

import java.util.*;

public class PGS23_K번째수 {

    public static int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];

        for(int i = 0 ; i < commands.length ; i++) {

            int start = commands[i][0];
            int end = commands[i][1];
            int num = commands[i][2];

            int[] arr = new int[end - start + 1];
            int idx = 0;

            for(int j = start-1 ; j < end ; j++) {

                arr[idx++] = array[j];

            }

            Arrays.sort(arr);
            answer[i] = arr[num - 1];

        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("Test case : " + Arrays.toString(solution(new int[]{1, 5, 2, 6, 5, 7, 4}, new int[][]{{2,5,3}, {4,4,1}, {1,7,3}})));
    }
}
