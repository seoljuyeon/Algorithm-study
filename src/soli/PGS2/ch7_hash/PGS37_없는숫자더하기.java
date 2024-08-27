package soli.PGS2.ch7_hash;

import java.util.HashSet;
import java.util.Set;

public class PGS37_없는숫자더하기 {
    public int solution(int[] numbers) {

        int[] num = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        Set<Integer> set = new HashSet<>();

        for(int n : numbers) {
            set.add(n);
        }

        int answer = 0;

        for(int n : num) {
            if(!set.contains(n)) {
                answer += n;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        PGS37_없는숫자더하기 pgs37_없는숫자더하기 = new PGS37_없는숫자더하기();
        System.out.println(pgs37_없는숫자더하기.solution(new int[]{1,2,3,4,6,7,8,0}));
        System.out.println(pgs37_없는숫자더하기.solution(new int[]{5,8,4,0,6,7,9}));
    }
}
