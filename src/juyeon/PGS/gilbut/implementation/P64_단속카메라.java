package juyeon.PGS.gilbut.implementation;

import java.util.Arrays;

public class P64_단속카메라 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}})); // 2
    }

    private static int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1]-o2[1];
        });

        int count = 1;

        int cam = routes[0][1];

        for (int[] route : routes) {
            if (cam < route[0]) {
                cam = route[1];
                count++;
            }
        }

        return count;
    }
}
