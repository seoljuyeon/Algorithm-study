package juyeon.PGS.gillbut_re.recursion;

import java.util.Arrays;

public class P15_쿼드압축_후_개수_세기_2 {
    public static void main(String[] args) {
        P15_쿼드압축_후_개수_세기_2 p15 = new P15_쿼드압축_후_개수_세기_2();

        System.out.println(Arrays.toString(p15.solution(new int[][]
                        {{1, 1, 0, 0},
                        {1, 0, 0, 0},
                        {1, 0, 0, 1},
                        {1, 1, 1, 1}}))); // [4, 9]

        System.out.println(Arrays.toString(p15.solution(new int[][]
                        {{1, 1, 1, 1, 1, 1, 1, 1},
                        {0, 1, 1, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 1, 1, 1, 1},
                        {0, 1, 0, 0, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 1, 0, 0, 1},
                        {0, 0, 0, 0, 1, 1, 1, 1}}))); // [10, 15]
    }

    private static int[] answer;

    public int[] solution(int[][] arr) {
        answer = new int[2];

        quad(arr, 0, 0, arr.length);

        return answer;
    }

    private void quad(int[][] arr, int x, int y, int size) {
        if (compression(arr, x, y, size)) {
            answer[arr[x][y]]++;
            return;
        }

        quad(arr, x, y, size / 2);
        quad(arr, x, y + size / 2, size / 2);
        quad(arr, x + size / 2, y, size / 2);
        quad(arr, x + size / 2, y + size / 2, size / 2);
    }

    private boolean compression(int[][] arr, int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[x][y] != arr[i][j]) return false;
            }
        }

        return true;
    }
}
