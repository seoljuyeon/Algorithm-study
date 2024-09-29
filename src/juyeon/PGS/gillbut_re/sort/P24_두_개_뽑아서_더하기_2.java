package juyeon.PGS.gillbut_re.sort;

import java.util.*;

public class P24_두_개_뽑아서_더하기_2 {
    public static void main(String[] args) {
        P24_두_개_뽑아서_더하기_2 p24 = new P24_두_개_뽑아서_더하기_2();

        System.out.println(Arrays.toString(p24.solution(new int[]{2, 1, 3, 4, 1}))); // [2,3,4,5,6,7]
        System.out.println(Arrays.toString(p24.solution(new int[]{5, 0, 2, 7}))); // [2,5,7,9,12]
    }

    public int[] solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().mapToInt(e -> e).toArray();
    }
}
