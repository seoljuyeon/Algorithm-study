package juyeon.PGS.gilbut.dataStructure;

import java.util.*;

public class P51_디스크_컨트롤러 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{0, 3}, {1, 9}, {2, 6}})); // 9
    }

    private static int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> (o1[0] - o2[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));

        int i = 0;
        int count = 0;
        int endTime = 0;
        int duration = 0;

        while (count < jobs.length) {
            while (i < jobs.length && jobs[i][0] <= endTime) {
                pq.add(jobs[i]);
                i++;
            }

            if (pq.isEmpty()) endTime = jobs[i][0];
            else {
                int[] temp = pq.poll();
                duration += endTime + temp[1] - temp[0];
                endTime += temp[1];
                count++;
            }
        }

        return duration / jobs.length;
    }
}
