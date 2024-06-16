package juyeon.PGS.gillbut_re.string;

import java.util.Arrays;

public class P05_자연수_뒤집어_배열로_만들기_2 {
    public static void main(String[] args) {
        P05_자연수_뒤집어_배열로_만들기_2 p5 = new P05_자연수_뒤집어_배열로_만들기_2();

        System.out.println(Arrays.toString(p5.solution(12345)));
    }

    public int[] solution(long n) {
        String str = Long.toString(n);
        int len = str.length();

        int[] answer = new int[len];

        char[] c = str.toCharArray();
        int idx = 0;

        for (int i = len - 1; i >= 0; i--) {
            answer[idx] = c[i] - '0';
            idx++;
        }

        return answer;
    }
}
