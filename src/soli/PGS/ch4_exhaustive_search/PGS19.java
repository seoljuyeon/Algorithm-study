package soli.PGS.ch4_exhaustive_search;

import java.util.Arrays;

public class PGS19 {

    public int[] solution(int brown, int yellow) {

        int n = brown + yellow;

        for(int a = 3 ; a <= n ; a++) {
            if(n % a == 0) {
                int b = n / a ;

                if((a-2)*(b-2) == yellow) {
                    return new int[]{Math.max(a, b), Math.min(a, b)};
                }
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {

        PGS19 pgs19 = new PGS19();

        System.out.println("Test Case 1 : " + Arrays.toString(pgs19.solution(10, 2)));
        System.out.println("Test Case 1 : " + Arrays.toString(pgs19.solution(8, 1)));
        System.out.println("Test Case 1 : " + Arrays.toString(pgs19.solution(24, 24)));
    }
}
