package juyeon.PGS.bruteForce;

import java.util.Arrays;

public class P19_카펫 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, 2))); // 4, 3
        System.out.println(Arrays.toString(solution(8, 1))); // 3, 3
        System.out.println(Arrays.toString(solution(24, 24))); // 8, 6
    }

    private static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int total = brown + yellow;

        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                int width = yellow / i;
                int height = i;

                if ((width + 2) * (height + 2) == total) {
                    answer[0] = width + 2;
                    answer[1] = height + 2;
                    break;
                }
            }
        }

        return answer;
    }
}
