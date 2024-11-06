package juyeon.PGS.drill.lv2;

import java.util.*;

public class PGS_프로세스 {
    public static void main(String[] args) {
        PGS_프로세스 pgs_프로세스 = new PGS_프로세스();

        System.out.println(pgs_프로세스.solution(new int[]{2, 1, 3, 2}, 2)); // 1
        System.out.println(pgs_프로세스.solution(new int[]{1, 1, 9, 1, 1, 1}, 0)); // 5
    }

    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>();

        int idx = 0;
        for (int i : priorities) {
            q.add(new int[]{i, idx++});
        }

        int answer = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            boolean hasHigher = q.stream().anyMatch(e -> e[0] > cur[0]);

            if (hasHigher) {
                q.add(cur);
            } else {
                answer++;
                if (cur[1] == location) return answer;
            }
        }

        return answer;
    }
}
