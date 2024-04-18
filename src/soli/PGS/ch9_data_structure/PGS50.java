package soli.PGS.ch9_data_structure;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PGS50 {
    public int solution(int[][] jobs) {

        Arrays.sort(jobs, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        // Arrays.sort(jobs, (a,b) -> (a[0]-b[0]));

        PriorityQueue<int[]> Q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        // PriorityQueue<int[]> Q = new PriorityQueue<>((a,b) -> (a[1] - b[1]));

        int now = 0;
        int sum = 0;
        int count = 0;
        int idx = 0;

        while(count < jobs.length) {
            //idx < jobs.length 안하면 IndexError -> 배열 안에서만 접근
            while(idx < jobs.length && jobs[idx][0] <= now) {
                Q.add(jobs[idx]);
                idx++;
            }
            if(!Q.isEmpty()){
                int[] job = Q.poll();
                now += job[1];
                sum += now - job[0];
                count++;
            } else {
                now = jobs[idx][0];
            }
        }

        return sum / jobs.length;
    }

    public static void main(String[] args) {
        PGS50 pgs50 = new PGS50();
        System.out.println("TEST CASE " + pgs50.solution(new int[][]{{0,3},{1,9},{2,9}}));
    }
}
