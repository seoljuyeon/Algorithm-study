package soli.PGS2.ch5_sort;

import java.util.Arrays;

public class PGS25_Hindex {

    public int solution(int[] citations) {

        int max = 0;

        Arrays.sort(citations);

        for(int i = citations.length - 1 ; i >= 0 ; i--){
            int min = (int)Math.min(citations[i], citations.length - i);
            if(max < min) {
                max = min;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        PGS25_Hindex pgs25 = new PGS25_Hindex();

        System.out.println("Test case1 :" + pgs25.solution(new int[]{3, 0, 6, 1, 5}));
    }
}
