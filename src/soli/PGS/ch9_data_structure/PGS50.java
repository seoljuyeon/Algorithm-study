package soli.PGS.ch9_data_structure;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PGS50 {

    public int solution(int[][] jobs) {
        // 작업 요청 시간에 따라 정렬
        Arrays.sort(jobs, (a, b) -> (a[0]-b[0]));

        // 소요 시간에 따라 정렬
        PriorityQueue<int[]> Q = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // 현재 시간
        int now = 0;
        // 대기시간, 소요 시간 합
        int sum = 0;
        // 배열 순회 인덱스
        int idx = 0;
        // 작업 수 추적
        int count = 0;

        // 작업 전부 끝날 때 까지
        while(count < jobs.length) {
            // 현재시간 이전에 요청된 작업 큐에 추가
            // 요청 시간이 현재 시간보다 같거나 작을 때 까지
            while(idx < jobs.length && jobs[idx][0] <= now  ) {
                // 작업을 우선 순위 큐에 추가
                Q.add(jobs[idx]);
                idx++;
            }

            // 우선 순위 큐가 비어있으면 다음 작업 시점으로 시간 이동
            if(Q.isEmpty()) {
                now = jobs[idx][0];
                // 아니면
            } else {
                // 우선 순위 큐에서 꺼내서 처리
                int[] job = Q.poll();
                // 현재 시간 업데이트
                now += job[1];
                // 대기시간, 처리시간 누적 - 요청시작시간
                sum += now - job[0] ;
                // 처리된 작업 수 증가
                count++;
            }

        }
        // 작업 평균 반환
        return sum / jobs.length;
    }

    public static void main(String[] args) {

    }
}
