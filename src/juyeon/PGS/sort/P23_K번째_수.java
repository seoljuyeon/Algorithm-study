package juyeon.PGS.sort;

import java.util.*;

public class P23_K번째_수 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}))); // 5, 6, 3
    }

    private static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        /**
         * 1 번 풀이~
         * **/

//        for (int x = 0; x < commands.length; x++) {
//
//            ArrayList<Integer> list = new ArrayList<>();
//
//            int i = commands[x][0];
//            int j = commands[x][1];
//            int k = commands[x][2];
//
//            for (int y = i - 1; y < j; y++) {
//                list.add(array[y]);
//            }
//
//            Collections.sort(list);
//
//            answer[x] = list.get(k - 1);
//        }

        /**
         * 2 번 풀이~
         * **/

        for (int x = 0; x < commands.length; x++) {

            int i = commands[x][0];
            int j = commands[x][1];
            int k = commands[x][2];

            int[] arr = Arrays.copyOfRange(array, i - 1, j);

            Arrays.sort(arr);

            answer[x] = arr[k - 1];
        }

        return answer;
    }
}