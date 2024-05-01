package soli.PGS.ch9_data_structure;

import java.util.Arrays;
import java.util.Stack;

public class PGS44 {

    public int[] solution(int[] prices) {

        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = prices.length - 1 - index;
        }
        return answer;

    }


    public static void main(String[] args) {
        PGS44 pgs44 = new PGS44();

        System.out.println(Arrays.toString(pgs44.solution(new int[] {1, 2, 3, 2, 3})));


    }
}
