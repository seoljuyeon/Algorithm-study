package soli.PGS2.ch6_binary_search;

import java.util.Arrays;

public class PGS31_입국심사 {

    public static long solution(int n, int[] times) {

        // 시간 정렬
        Arrays.sort(times);

        // 최소 걸리는 시간
        long min = 1;
        // 최대 걸리는 시간
        long max = (long) n * times[times.length-1];
        long answer = max;

        while(min <= max) {
            // 중간값
            long mid = (min + max) / 2;
            long count = 0;

            // 중간값 시간 내에 몇 명 처리 할 수 있는지 확인
            for(int time : times) {
                count += (mid / time);
            }

            if(count >= n) {
                answer = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{7, 10})); // 28
    }
}
