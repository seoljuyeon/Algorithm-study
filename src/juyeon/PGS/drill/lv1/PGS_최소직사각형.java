package juyeon.PGS.drill.lv1;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PGS_최소직사각형 {

    @Test
    public void test1() {
        PGS_최소직사각형 pgs_최소직사각형 = new PGS_최소직사각형();

        int input1 = pgs_최소직사각형.solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}});
        assertEquals(4000, input1);
    }

    @Test
    public void test2() {
        PGS_최소직사각형 pgs_최소직사각형 = new PGS_최소직사각형();

        int input2 = pgs_최소직사각형.solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}});
        assertEquals(120, input2);
    }

    @Test
    public void test3() {
        PGS_최소직사각형 pgs_최소직사각형 = new PGS_최소직사각형();

        int input3 = pgs_최소직사각형.solution(new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}});
        assertEquals(133, input3);
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
