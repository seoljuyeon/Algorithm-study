package juyeon.PGS.drill.lv1;

import java.util.*;

public class PGS_최소직사각형 {
    public static void main(String[] args) {
        PGS_최소직사각형 pgs_최소직사각형 = new PGS_최소직사각형();

        System.out.println(pgs_최소직사각형.solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}})); // 4000
        System.out.println(pgs_최소직사각형.solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}})); // 120
        System.out.println(pgs_최소직사각형.solution(new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}})); // 133
    }

    public int solution(int[][] sizes) {
        for (int[] arr : sizes) {
            Arrays.sort(arr);
        }

        int x = 0, y = 0;

        for (int[] arr : sizes) {
            x = Math.max(x, arr[0]);
            y = Math.max(y, arr[1]);
        }

        return x * y;
    }
}
