package juyeon.PGS.array;

import java.util.Arrays;
import java.util.HashSet;

class Point {
    long x;
    long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}

public class P01_교점에_별_만들기 {

    static long minx = Long.MAX_VALUE, miny = Long.MAX_VALUE;
    static long maxx = Long.MIN_VALUE, maxy = Long.MIN_VALUE;

    public static void main(String[] args) {
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        String[] result = solution(line);

        for (String str : result) {
            System.out.println(str);
        }
    }

//    Ax + By + C = 0
//    Dx + Ey + F = 0

//    x = (BF-CE) / (AE-BD)
//    y = (CD-AF) / (AE-BD)

//    AE - BD = 0 일 때, 두 직선은 평행

    private static String[] solution(int[][] line) {
        String[] answer = {};

        HashSet<Point> set = new HashSet<>();

        for (int i = 0; i < line.length - 1; i++) {

            long A = line[i][0];
            long B = line[i][1];
            long C = line[i][2];

            for (int j = i + 1; j < line.length; j++) {

                long D = line[j][0];
                long E = line[j][1];
                long F = line[j][2];

                // 두 직선이 평행할 때
                long m = A * E - B * D;
                if (m == 0) continue;

                long x = (B * F - C * E) / (A * E - B * D);
                long y = (C * D - A * F) / (A * E - B * D);

                // x, y가 정수 좌표가 아닐 때
                if (!(x % 1 == 0 && y % 1 == 0)) continue;

                set.add(new Point(x, y));

                maxx = Math.max(maxx, x);
                maxy = Math.max(maxy, y);
                minx = Math.min(minx, x);
                miny = Math.min(miny, y);
            }
        }

        long height = maxy - miny + 1;
        long width = maxx - minx + 1;

        answer = new String[(int) height];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < width; i++) {
            sb.append(".");
        }

        Arrays.fill(answer, sb.toString());

        long nx, ny;
        for (Point p : set) {
            nx = p.x - minx;
            ny = maxy - p.y;

            StringBuilder sbr = new StringBuilder(answer[(int) ny]);
            sbr.setCharAt((int) nx, '*');
            answer[(int) ny] = sbr.toString();

        }

        return answer;
    }
}
