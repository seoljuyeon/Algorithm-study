package juyeon.PGS.gilbut.hash;

import java.util.ArrayList;

// 해시 문제 아님~
public class P33_평행 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{1, 4}, {9, 2}, {3, 8}, {11, 6}})); // 1
        System.out.println(solution(new int[][] {{3, 5}, {4, 1}, {2, 4}, {5, 10}})); // 0
    }

    private static int solution(int[][] dots) {
//        문제 접근 자체가 틀려먹은 코드
//        ArrayList<Double> list = new ArrayList<>();

//        for (int i = 0; i < 3; i++) {
//            for (int j = i + 1; j < 4; j++) {
//                double m = (double) (dots[j][1] - dots[i][1]) / (dots[j][0] - dots[i][0]);
//
//                if (list.contains(m)) return 1;
//                    else list.add(m);
//            }
//        }

        double m1 = (double) (dots[1][1] - dots[0][1]) / (dots[1][0] - dots[0][0]);
        double m2 = (double) (dots[3][1] - dots[2][1]) / (dots[3][0] - dots[2][0]);

        if (m1 == m2) return 1;

        m1 = (double) (dots[2][1] - dots[0][1]) / (dots[2][0] - dots[0][0]);
        m2 = (double) (dots[3][1] - dots[1][1]) / (dots[3][0] - dots[1][0]);

        if (m1 == m2) return 1;

        m1 = (double) (dots[3][1] - dots[0][1]) / (dots[3][0] - dots[0][0]);
        m2 = (double) (dots[2][1] - dots[1][1]) / (dots[2][0] - dots[1][0]);

        if (m1 == m2) return 1;

        return 0;
    }
}
