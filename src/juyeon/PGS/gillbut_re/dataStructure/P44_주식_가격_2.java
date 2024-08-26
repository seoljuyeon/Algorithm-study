package juyeon.PGS.gillbut_re.dataStructure;

import java.util.Arrays;

public class P44_주식_가격_2 {
    public static void main(String[] args) {
        P44_주식_가격_2 p44 = new P44_주식_가격_2();

        System.out.println(Arrays.toString(p44.solution(new int[] {1, 2, 3, 2, 3}))); // 4 3 1 1 0

    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;

                if (prices[i] > prices[j]) break;
            }
        }

        return answer;
    }
}
