package soli.PGS.ch10_implement;

import java.util.Arrays;

public class PGS64 {
    public int solution(int[][] routes) {

        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        // Arrays.sort(routes, new Comparator<int[]>() {
        // @Override
        // public int compare(int[] o1, int[] o2) {
        // return Integer.compare(o1[1], o2[1]);
        // 또는 return o1[1] - o2[1];
        // }
        // }

        int location = Integer.MIN_VALUE;
        int answer = 0;

        for(int i = 0 ; i < routes.length ; i++) {
            if(routes[i][0] > location) {
                location = routes[i][1];
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        PGS64 pgs64 = new PGS64();

        System.out.println(pgs64.solution(new int[][]{{-20, -15}, {-14,-5}, {-18,-13}, {-5,-3}}));
    }
}
