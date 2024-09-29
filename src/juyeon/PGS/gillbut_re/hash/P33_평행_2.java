package juyeon.PGS.gillbut_re.hash;

public class P33_평행_2 {
    public static void main(String[] args) {
        P33_평행_2 p33 = new P33_평행_2();

        System.out.println(p33.solution(new int[][] {{1, 4}, {9, 2}, {3, 8}, {11, 6}})); // 1
        System.out.println(p33.solution(new int[][] {{3, 5}, {4, 1}, {2, 4}, {5, 10}})); // 0
    }

    public int solution(int[][] dots) {
        double m1 = (double) (dots[0][0] - dots[1][0]) / (dots[0][1] - dots[1][1]);
        double m2 = (double) (dots[2][0] - dots[3][0]) / (dots[2][1] - dots[3][1]);

        if (m1 == m2) return 1;

        m1 = (double) (dots[0][0] - dots[2][0]) / (dots[0][1] - dots[2][1]);
        m2 = (double) (dots[1][0] - dots[3][0]) / (dots[1][1] - dots[3][1]);

        if (m1 == m2) return 1;

        m1 = (double) (dots[0][0] - dots[3][0]) / (dots[0][1] - dots[3][1]);
        m2 = (double) (dots[1][0] - dots[2][0]) / (dots[1][1] - dots[2][1]);

        if (m1 == m2) return 1;

        return 0;
    }
}
