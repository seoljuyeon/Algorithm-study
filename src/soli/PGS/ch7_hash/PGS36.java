package soli.PGS.ch7_hash;

import java.util.HashSet;
import java.util.Set;

public class PGS36 {

    public int solution(int[] numbers) {
        int answer = 0;

        int[] num = {0,1,2,3,4,5,6,7,8,9};

        Set<Integer> set = new HashSet<>();
        for(int i : numbers) {
            set.add(i);
        }

        for(int i : num) {
            if(!set.contains(i)){
                answer += i;
            }

//
//        return answer;
//        int answer = 0;
//
//        for(int i : numbers) {
//            answer += i;
        }

        return 45 - answer;
    }

    public static void main(String[] args) {

        PGS36 pgs36 = new PGS36();

        System.out.println("Test Code 1 : " + pgs36.solution(new int[]{1, 2, 3, 4, 6, 7, 8, 0}));
        System.out.println("Test Code 1 : " + pgs36.solution(new int[]{5, 8, 4, 0, 6, 7, 9}));
    }
}
