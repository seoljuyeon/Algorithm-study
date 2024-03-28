package juyeon.PGS.gilbut.sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P24_두_개_뽑아서_더하기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 3, 4, 1}))); // 2, 3, 4, 5, 6, 7
        System.out.println(Arrays.toString(solution(new int[]{5, 0, 2, 7}))); // 2, 5, 7, 9, 12
    }

    private static int[] solution(int[] numbers) {
        int[] answer = {};

        Set<Integer> set = new HashSet<>();

//        for (int i = 0; i < numbers.length; i++) {
//            for (int j = 0; j < numbers.length; j++) {
//                if (i == j) continue;
//
//                set.add(numbers[i] + numbers[j]);
//            }
//        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        answer = set.stream().sorted().mapToInt(e -> e).toArray();

        return answer;
    }
}
