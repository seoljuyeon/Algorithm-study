package soli.PGS2.ch4_exhaustive_search;

import soli.PGS.ch4_exhaustive_search.PGS19;

import java.util.Arrays;

public class PGS19_카펫 {

    public int[] solution(int brown, int yellow) {

        int n = brown + yellow;

        int y;

        for(int i = 3 ; i <= Math.sqrt(n) ; i++) {
            if(n % i == 0) {
                y = n / i;

                if((i-2)*(y-2)== yellow) {
                    return new int[]{y, i};
                }
            }
        }

        return new int[]{0,0};
    }

    public static void main(String[] args) {

        PGS19 pgs19 = new PGS19();

        System.out.println("Test Case 1 : " + Arrays.toString(pgs19.solution(10, 2)));
        System.out.println("Test Case 1 : " + Arrays.toString(pgs19.solution(8, 1)));
        System.out.println("Test Case 1 : " + Arrays.toString(pgs19.solution(24, 24)));
    }
}
