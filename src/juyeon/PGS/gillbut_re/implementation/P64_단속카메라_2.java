package juyeon.PGS.gillbut_re.implementation;

import java.util.*;

public class P64_단속카메라_2 {
    public static void main(String[] args) {
        P64_단속카메라_2 p64 = new P64_단속카메라_2();

        System.out.println(p64.solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}})); // 2
    }

    public int solution(int[][] routes) {
        int count = 1;

        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1];
        });

        int cam = routes[0][1];

        for (int[] arr : routes) {
            if (cam < arr[0]) {
                count++;
                cam = arr[1];
            }
        }

        return count;
    }
}
