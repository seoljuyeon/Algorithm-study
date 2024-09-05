package juyeon.PGS.gillbut_re.dataStructure;

import java.util.*;

public class P51_디스크_컨트롤러_2 {
    public static void main(String[] args) {
        P51_디스크_컨트롤러_2 p51 = new P51_디스크_컨트롤러_2();

        System.out.println(p51.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}})); // 9
    }

    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> (o1[0] - o2[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));

        int idx = 0;
        int time = 0;
        int duration = 0;
        int count = 0;

        while (count < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.add(jobs[idx]);
                idx++;
            }

            if (pq.isEmpty()) time = jobs[idx][0];
            else {
                int[] job = pq.poll();
                duration += job[1] + time - job[0];
                time += job[1];
                count++;
            }
        }

        return duration / jobs.length;
    }
}