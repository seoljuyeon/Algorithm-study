package juyeon.PGS.gillbut_re.recursion;

import java.util.*;

public class P16_하노이의_탑 {
    public static void main(String[] args) {
        P16_하노이의_탑 p16 = new P16_하노이의_탑();

        // [ [1,2], [1,3], [2,3] ]
        for (int[] arr : p16.solution(2)) {
            System.out.print(Arrays.toString(arr) + " ");
        }
    }

    private static List<int[]> list;

    public int[][] solution(int n) {
        list = new ArrayList<>();

        hanoi(n, 1, 2, 3);

        int[][] answer = new int[list.size()][2];

        int i = 0;

        for (int[] arr : list) {
            answer[i][0] = arr[0];
            answer[i][1] = arr[1];
            i++;
        }

        return answer;
    }

    private void hanoi(int n, int from, int via, int to) {
        if (n == 1) {
            list.add(new int[]{from, to});
        } else {
            hanoi(n - 1, from, to, via);
            list.add(new int[]{from, to});
            hanoi(n - 1, via, from, to);
        }
    }
}
