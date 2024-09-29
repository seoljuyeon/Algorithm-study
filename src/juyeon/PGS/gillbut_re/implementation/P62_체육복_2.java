package juyeon.PGS.gillbut_re.implementation;

import java.util.Arrays;

public class P62_체육복_2 {
    public static void main(String[] args) {
        P62_체육복_2 p62 = new P62_체육복_2();

        System.out.println(p62.solution(5, new int[]{2, 4}, new int[]{3}));
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int count = 0;

        int[] arr = new int[n + 1];

        Arrays.fill(arr, 1);

        for (int i : lost) arr[i]--;

        for (int i : reserve) arr[i]++;

        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) {
                if (i > 1 && arr[i - 1] > 1) {
                    arr[i]++;
                    arr[i - 1]--;
                } else if (i < n && arr[i + 1] > 1) {
                    arr[i]++;
                    arr[i + 1]--;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (arr[i] >= 1) count++;
        }

        return count;
    }
}
