package soli.PGS.ch_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PGS23_pre {
    public static int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer>[] A = new ArrayList[commands.length];

        for(int i = 0; i < commands.length; i++) {
            A[i] = new ArrayList<>();
            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                A[i].add(array[j]);
            }
            Collections.sort(A[i]);
        }

        int[] result = new int[commands.length];

        for(int i = 0; i < commands.length; i++) {
            result[i] = A[i].get(commands[i][2] - 1);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Test case : " + Arrays.toString(solution(new int[]{1, 5, 2, 6, 5, 7, 4}, new int[][]{{2,5,3}, {4,4,1}, {1,7,3}})));
    }
}
