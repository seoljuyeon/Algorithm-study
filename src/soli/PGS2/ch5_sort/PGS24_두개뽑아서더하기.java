package soli.PGS2.ch5_sort;

import soli.PGS.ch_array.PGS24;

import java.util.*;

public class PGS24_두개뽑아서더하기 {

    public int[] solution(int[] numbers) {

        Set<Integer> num = new HashSet<>();

        for(int i = 0 ; i < numbers.length - 1; i++) {
            for(int j = i+1 ; j < numbers.length ; j++) {
                num.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = new int[num.size()];
        int idx = 0;
        for(int n : num) {
            answer[idx++] = n;
        }
        Arrays.sort(answer);

        return answer;
    }

    public static void main(String[] args){
        PGS24_두개뽑아서더하기 pgs24 = new PGS24_두개뽑아서더하기();
        System.out.println("Test case1 : " + Arrays.toString(pgs24.solution(new int[]{2,1,3,4,1})));
        System.out.println("Test case2 : " + Arrays.toString(pgs24.solution(new int[]{5,0,2,7})));
    }
}
