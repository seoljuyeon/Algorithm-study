package soli.PGS.ch_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PGS23 {

    public static int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];

        for(int i = 0 ; i < commands.length ; i++) {

            ArrayList<Integer> arr = new ArrayList<>();

            int a = commands[i][0];
            int b = commands[i][1];
            int c = commands[i][2];
            for(int j = a-1 ; j < b ; j++) {
                arr.add(array[j]);
            }
            Collections.sort(arr);
            answer[i] = arr.get(c-1);
        }

        return answer;
    }


    public static void main(String[] args) {
        System.out.println("Test case : " + Arrays.toString(solution(new int[]{1, 5, 2, 6, 5, 7, 4}, new int[][]{{2,5,3}, {4,4,1}, {1,7,3}})));
    }
}
