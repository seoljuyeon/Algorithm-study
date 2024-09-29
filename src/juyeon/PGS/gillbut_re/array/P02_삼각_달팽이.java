package juyeon.PGS.gillbut_re.array;

import java.util.*;

public class P02_삼각_달팽이 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4))); // [1,2,9,3,10,8,4,5,6,7]
        System.out.println(Arrays.toString(solution(5))); // [1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]
        System.out.println(Arrays.toString(solution(6))); // [1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]
    }

    private static int[] solution(int n) {
        int[][] tri = new int[n][];

        for (int i = 0; i < n; i++) {
            tri[i] = new int[i + 1];
        }

        int x = -1, y = 0, num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // 아래
                if (i % 3 == 0) x++;
                // 오른쪽
                else if (i % 3 == 1) y++;
                // 왼쪽위 대각선
                else if (i % 3 == 2) {
                    x--;
                    y--;
                }

                tri[x][y] = num++;
            }
        }

        int idx = 0;

        int[] answer = new int[num - 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                answer[idx++] = tri[i][j];
            }
        }

        return answer;
    }
}
