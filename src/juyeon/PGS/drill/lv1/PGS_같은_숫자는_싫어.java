package juyeon.PGS.drill.lv1;

import java.util.*;

public class PGS_같은_숫자는_싫어 {
    public static void main(String[] args) {
        PGS_같은_숫자는_싫어 pgs_같은_숫자는_싫어 = new PGS_같은_숫자는_싫어();

        System.out.println(Arrays.toString(pgs_같은_숫자는_싫어.solution(new int[]{1, 1, 3, 3, 0, 1, 1}))); // [1,3,0,1]
        System.out.println(Arrays.toString(pgs_같은_숫자는_싫어.solution(new int[]{4, 4, 4, 3, 3}))); // [4,3]
    }

    public int[] solution(int[] arr) {
        Stack<Integer> st = new Stack<>();

        for (int i : arr) {
            if (!st.isEmpty() && st.peek() == i) continue;
            else st.push(i);
        }

        int idx = 1;
        int size = st.size();

        int[] answer = new int[size];

        while (!st.empty()) {
            answer[size - idx] = st.pop();
            idx++;
        }

        return answer;

        // stream~
//        Stack<Integer> st = new Stack<>();
//
//        for (int i : arr) {
//            if (st.isEmpty() || st.peek() != i) {
//                st.push(i);
//            }
//        }
//
//        List<Integer> list = new ArrayList<>(st);
//
//        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
