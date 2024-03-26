package juyeon.PGS.gilbut.hash;

import java.util.HashSet;

public class P36_없는_숫자_더하기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 6, 7, 8, 0})); // 14
        System.out.println(solution(new int[]{5, 8, 4, 0, 6, 7, 9})); // 6
    }

    private static int solution(int[] numbers) {
//        int m = 0;
//        int n = 0;
//
//        for (int i = 0; i <= 9; i++) {
//            m += i;
//        }
//
//        for (int num : numbers) {
//            n += num;
//        }
//
//        return m - n;

        // 해시
        HashSet<Integer> set = new HashSet<>();

        for (int num : numbers) set.add(num);

        int sum = 0;

        for (int i = 0; i <= 9; i++) {
            if (set.contains(i)) continue;
            sum += i;
        }

        return sum;
    }
}
