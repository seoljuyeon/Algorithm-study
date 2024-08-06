package juyeon.PGS.gillbut_re.binarySearch;

import java.util.*;

public class P31_입국심사_2 {
    public static void main(String[] args) {
        P31_입국심사_2 p31 = new P31_입국심사_2();

        System.out.println(p31.solution(6, new int[]{7, 10})); // 28
        System.out.println(p31.solution(6, new int[]{10, 1})); // 6
        System.out.println(p31.solution(6, new int[]{2, 5})); // 10
    }

    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long min = 1;
        long max = (long) n * times[times.length - 1];
        long mid, count;

        while (min < max) {
            count = 0;
            mid = (min + max) / 2;

            for (int time : times)
                count += mid / time;

            if (count >= n) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return max;
    }
}
