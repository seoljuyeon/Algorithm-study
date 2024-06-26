package juyeon.PGS.gillbut_re.bruteForce;

import java.util.Arrays;

public class P19_카펫_2 {
    public static void main(String[] args) {
        P19_카펫_2 p19 = new P19_카펫_2();

        System.out.println(Arrays.toString(p19.solution(10, 2))); // [4, 3]
        System.out.println(Arrays.toString(p19.solution(8, 1))); // [3, 3]
        System.out.println(Arrays.toString(p19.solution(24, 24))); // [8, 6]
    }

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int total = brown + yellow;

        for (int width = brown / 2; width > 0; width--) {
            if (total % width == 0) {
                int height = total / width;

                if ((width - 2) * (height - 2) == yellow) {
                    answer[0] = width;
                    answer[1] = height;
                    break;
                }
            }
        }

        return answer;
    }
}
