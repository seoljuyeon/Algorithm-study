package juyeon.PGS.bruteForce;

import java.util.ArrayList;
import java.util.Arrays;

public class P18_모의고사 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5}))); // [1]
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 2, 4, 2}))); // [1, 2, 3]
    }

    private static int[] first = {1, 2, 3, 4, 5};
    private static int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
    private static int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    private static int[] solution(int[] answers) {
        int f = 0;
        int s = 0;
        int t = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == first[i % 5]) f++;
            if (answers[i] == second[i % 8]) s++;
            if (answers[i] == third[i % 10]) t++;
        }

        int max = Math.max(Math.max(f, s), t);

        ArrayList<Integer> arr = new ArrayList<>();

        if (max == f) arr.add(1);
        if (max == s) arr.add(2);
        if (max == t) arr.add(3);

        int size = arr.size();

        int[] answer = new int[size];

        for (int i = 0; i < size; i++) {
            answer[i] = arr.get(i);
        }

        return answer;
    }
}
