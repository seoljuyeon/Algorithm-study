package juyeon.PGS.gillbut_re.sort;

import java.util.*;

public class P23_K번째_수_2 {
    public static void main(String[] args) {
        P23_K번째_수_2 p23 = new P23_K번째_수_2();

        System.out.println(Arrays.toString(p23.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}))); // [5, 6, 3]
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int idx = 0;

        for (int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];

//            List<Integer> list = new ArrayList<>();
//
//            for (int e = i; e <= j; e++) {
//                list.add(array[e - 1]);
//            }
//
//            int[] temp = list.stream().sorted().mapToInt(v -> v).toArray();

            int[] temp = Arrays.copyOfRange(array, i - 1, j);

            Arrays.sort(temp);

            answer[idx] = temp[k - 1];
            idx++;
        }

        return answer;
    }
}
