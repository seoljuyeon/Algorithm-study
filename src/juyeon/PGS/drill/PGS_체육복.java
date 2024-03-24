package juyeon.PGS.drill;

import java.util.*;

public class PGS_체육복 {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 4}, new int[]{3})); // 4
    }

    private static int solution(int n, int[] lost, int[] reserve) {
        int count = 0;

        int[] all = new int[n + 1];

        Arrays.fill(all, 1);

        for (int i = 0; i < lost.length; i++) {
            all[lost[i]] = 0;
        }

        for (int i = 0; i < reserve.length; i++) {
            all[reserve[i]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (all[i] == 0) {
                if (i > 1 && all[i - 1] > 1) {
                    all[i]++;
                    all[i - 1]--;
                } else if (i < n && all[i + 1] > 1) {
                    all[i]++;
                    all[i + 1]--;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (all[i] != 0) count++;
        }

        return count;
    }
}
