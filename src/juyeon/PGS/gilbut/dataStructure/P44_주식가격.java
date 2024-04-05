package juyeon.PGS.gilbut.dataStructure;

import java.util.Arrays;

public class P44_주식가격 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {1, 2, 3, 2, 3}))); // 4 3 1 1 0
    }

    private static int[] solution(int[] prices) {
        int n = prices.length;

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                answer[i]++;

                if (prices[i] > prices[j]) break;
            }
        }

        return answer;
    }
}
