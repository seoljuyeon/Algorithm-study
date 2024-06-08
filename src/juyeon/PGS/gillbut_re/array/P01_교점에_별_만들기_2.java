package juyeon.PGS.gillbut_re.array;

import java.util.*;

public class P01_교점에_별_만들기_2 {
    public static void main(String[] args) {
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        String[] result = solution(line);

        for (String str : result) {
            System.out.println(str);
        }
    }

    static long maxx = Long.MIN_VALUE;
    static long minx = Long.MAX_VALUE;
    static long maxy = Long.MIN_VALUE;
    static long miny = Long.MAX_VALUE;

    private static String[] solution(int[][] line) {
        String[] answer = {};

        Set<List<Long>> set = new HashSet<>();

        for (int i = 0; i < line.length - 1; i++) {

            long A = line[i][0];
            long B = line[i][1];
            long C = line[i][2];

            for (int j = i + 1; j < line.length; j++) {

                long D = line[j][0];
                long E = line[j][1];
                long F = line[j][2];

                long m = A * E - B * D;
                if (m == 0) continue;

                long bfce = B * F - C * E;
                long cdaf = C * D - A * F;

                if (!(bfce % m == 0 && cdaf % m == 0)) continue;

                long x = bfce / m;
                long y = cdaf / m;

                set.add(Arrays.asList(x, y));

                maxx = Math.max(maxx, x);
                minx = Math.min(minx, x);

                maxy = Math.max(maxy, y);
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
        for (List<Long> p : set) {
            nx = p.get(0) - minx;
            ny = maxy - p.get(1);

            sb = new StringBuilder(answer[(int) ny]);

            sb.setCharAt((int) nx, '*');
            answer[(int) ny] = sb.toString();
        }

        return answer;
    }
}
