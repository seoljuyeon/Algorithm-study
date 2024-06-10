package soli.PGS2.ch1_array;
import soli.PGS.ch1_array.PGS2;

import java.util.*;

public class PGS1_교점에별만들기 {

    public String[] solution(int[][] line) {

        List<int[]> list = new ArrayList<>();

        for(int i = 0 ; i <line.length ; i++) {
            for(int j = i + 1 ; j < line.length ; j++) {
                int a = line[i][0];
                int b = line[i][1];
                int e = line[i][2];

                int c = line[j][0];
                int d = line[j][1];
                int f = line[j][2];

                long denom = (long)a*d - (long)b*c;
                if(denom != 0) {
                    long longX = (long) b*f - (long)e*d;
                    long longY = (long) e*c - (long)a*f;

                    if(longX%denom == 0 && longY%denom == 0) {
                        int x = (int)(longX/denom);
                        int y = (int)(longY/denom);

                        list.add(new int[]{x,y});
                    }
                }
            }
        }


        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        for(int[] l : list) {
            int x = l[0];
            int y = l[1];
            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);
        }

        int width = maxX - minX + 1;
        int height = maxY - minY + 1;

        char[][] answer = new char[height][width];

        for (char[] row : answer) {
            Arrays.fill(row, '.');
        }

        for(int[] l : list) {
            int x = l[0] - minX;
            int y = maxY - l[1];
            answer[y][x] = '*';
        }

        String[] result = new String[height];

        for(int i = 0 ; i < height ; i++) {
            result[i] = new String(answer[i]);
        }

        return result;

    }

    public boolean isInteger(long x, long y) {
        if (x == (int) x && y == (int) y) return true;
        else return false;
    }

    public static void main(String[] args) {
        PGS1_교점에별만들기 sol = new PGS1_교점에별만들기();

        System.out.println(Arrays.toString(sol.solution(new int[][]{{1, 0, 0}, {0, 1, 0}, {1, 0, -1000}, {0, 1, -1000}, {1, -1, 0}})));
        System.out.println(Arrays.toString(sol.solution(new int[][]{{1, 0, 0}, {0, 1, 0}, {1, 1, 0}, {-1, 1, 0}, {1, -1, 0}})));
        System.out.println(Arrays.toString(sol.solution(new int[][]{{1, 0, -1}, {0, 1, -1}, {1, 0, 1}, {0, 1, 1}, {1, -1, 0}})));
        System.out.println(Arrays.toString(sol.solution(new int[][]{{100000, 0, 0}, {0, 100000, 0}, {-100000, 100000, 100000}, {100000, 100000, -100000}})));
        System.out.println(Arrays.toString(sol.solution(new int[][]{{1, 1, 1}, {1, 1, 2}, {1, 1, 3}, {1, 1, 4}})));
        System.out.println(Arrays.toString(sol.solution(new int[][]{{1, -1, 0}, {2, -1, 0}})));
        System.out.println(Arrays.toString(sol.solution(new int[][]{{1, -1, 0}, {2, -1, 0}, {4, -1, 0}})));
    }
}
