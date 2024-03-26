package juyeon.PGS.gilbut.sort;

import java.util.Arrays;

public class P25_H_index {
    public static void main(String[] args) {
        System.out.println((solution(new int[]{3, 0, 6, 1, 5}))); // 3
    }

    private static int solution(int[] citations) {

        Arrays.sort(citations);

        int n = citations.length;
        int max = citations[n - 1];

        int k = 0;

        for (int h = 0; h <= max; h++) {
            for (int i = 0; i < n; i++) {
                if (citations[i] >= h) k++;
            }
            if (h >= k) return k;
            else k = 0;
        }

        return 0;
    }
}
