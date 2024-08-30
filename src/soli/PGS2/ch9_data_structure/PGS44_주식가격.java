package soli.PGS2.ch9_data_structure;

import java.util.Arrays;
import java.util.Stack;

public class PGS44_주식가격 {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < prices.length ; i++) {
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = i - idx;

            }
            stack.add(i);
        }

        while(!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices.length - 1 - idx;

        }

        return answer;

    }

    public static void main(String[] args) {
        PGS44_주식가격 pgs44 = new PGS44_주식가격();

        System.out.println(Arrays.toString(pgs44.solution(new int[] {1, 2, 3, 2, 3})));

    }
}
