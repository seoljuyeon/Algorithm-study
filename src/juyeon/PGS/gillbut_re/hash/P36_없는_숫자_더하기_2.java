package juyeon.PGS.gillbut_re.hash;

import java.util.*;

public class P36_없는_숫자_더하기_2 {
    public static void main(String[] args) {
        P36_없는_숫자_더하기_2 p36 = new P36_없는_숫자_더하기_2();

        System.out.println(p36.solution(new int[]{1, 2, 3, 4, 6, 7, 8, 0})); // 14
        System.out.println(p36.solution(new int[]{5, 8, 4, 0, 6, 7, 9})); // 6
    }

    public int solution(int[] numbers) {
        int answer = 0;

        Set<Integer> set = new HashSet<>();

        for (int num : numbers) set.add(num);

        for (int i = 0; i <= 9; i++) {
            if (!set.contains(i)) answer += i;
        }

        return answer;

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
    }
}
