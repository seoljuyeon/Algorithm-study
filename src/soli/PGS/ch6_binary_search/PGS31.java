package soli.PGS.ch6_binary_search;

import java.util.Arrays;

public class PGS31 {

    public static long solution(int n, int[] times) {

        Arrays.sort(times);

        long min = 1;
        long max = (long) n * (times[times.length -1]);    // 최악의 경우 나오는 시간
        long answer = max;

        while(min <= max) {
            long mid = (min + max) / 2;
            long count = 0;

            for(int time : times) {
                count += mid / time;    // mid 동안 심사할 수 있는 사람 수 (각 심사대마다)
            }

            if(count >= n) {
                answer = mid;
                max = mid - 1;
            }
            else {
                min = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{7, 10})); // 28

    }
}
