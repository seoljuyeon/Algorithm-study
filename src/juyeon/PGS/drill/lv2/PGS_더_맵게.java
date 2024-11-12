package juyeon.PGS.drill.lv2;

import java.util.*;

public class PGS_더_맵게 {
    public static void main(String[] args) {
        PGS_더_맵게 pgs_더_맵게 = new PGS_더_맵게();

        System.out.println(pgs_더_맵게.solution(new int[]{1, 2, 3, 9, 10, 12}, 7)); // 2
    }

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i : scoville) {
            q.add(i);
        }

        int count = 0;
        int fst = q.poll();

        while (fst < K) {
            int sec = q.poll();

            q.add(fst + sec * 2);
            count++;
            fst = q.poll();

            if (fst < K && q.size() < 1) return -1;
        }

        return count;
    }
}
