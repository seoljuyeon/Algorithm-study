package juyeon.PGS.gillbut_re.string;

import java.util.Arrays;

public class P10_이진_변환_반복하기_2 {
    public static void main(String[] args) {
        P10_이진_변환_반복하기_2 p10 = new P10_이진_변환_반복하기_2();

        System.out.println(Arrays.toString(p10.solution("110010101001"))); // [3, 8]
        System.out.println(Arrays.toString(p10.solution("01110"))); // [3, 3]
        System.out.println(Arrays.toString(p10.solution("1111111"))); // [4, 1]
    }

    public int[] solution(String s) {
        int[] answer = new int[2];

        int count = 0;
        int zero = 0;

        while(!s.equals("1")) {
            count++;
            int one = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') one++;
                else zero++;
            }

            s = Integer.toString(one, 2);
        }

        answer[0] = count;
        answer[1] = zero;

        return answer;
    }
}
