package soli.PGS2.ch4_exhaustive_search;

import java.util.HashSet;
import java.util.Set;

public class PGS21_소수찾기 {


    static Set<Integer> set;

    public static int solution(String numbers) {

        set = new HashSet<>();

        recursion("", numbers);
        int answer = 0;

        for (int num : set) {
            if (num != 1 && num != 0) {
                if (isPrime(num)) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void recursion(String str, String numbers) {

        if (!str.equals("")) {
            set.add(Integer.parseInt(str));
        }

        for (int i = 0; i < numbers.length(); i++) {
            recursion(str + numbers.charAt(i), numbers.substring(0, i) + numbers.substring(i + 1));
        }

    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(solution("17"));
        System.out.println(solution("011"));
    }
}
