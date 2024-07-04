package juyeon.PGS.gillbut_re.sort;

import java.util.Arrays;

public class P25_H_index_2 {
    public static void main(String[] args) {
        P25_H_index_2 p25 = new P25_H_index_2();

        System.out.println(p25.solution(new int[]{3, 0, 6, 1, 5})); // 3
    }

    public int solution(int[] citations) {
        int h = 0;

        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            h = citations.length - i;

            if (citations[i] >= h) {
                return h;
            }
        }

        return 0;
    }
}
