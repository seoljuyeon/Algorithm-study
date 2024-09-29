package juyeon.PGS.drill;

import java.util.*;

// 개쓰레기문제같음요
public class PGS_주식가격 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {1, 2, 3, 2, 3}))); // 4, 3, 1, 1, 0
    }

    private static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {

                // 어쨌든 가격이 1초는 유지 되니까 먼저 더해줌 ^^;
                answer[i]++;

                if (prices[i] > prices[j]) break;
            }
        }

        return answer;
    }
}
