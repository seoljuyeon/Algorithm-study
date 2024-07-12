package juyeon.ELC;

import java.io.*;
import java.util.*;

public class ELC_주택_청약 {
    static int[][] map = {{85, 300, 250, 200},
            {102, 600, 400, 300},
            {135, 1000, 700, 400},
            {0, 1500, 1000, 500}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int count = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()); // 전용 면적
            int b = Integer.parseInt(st.nextToken()); // 거주지
            int c = Integer.parseInt(st.nextToken()); // 납입 금액

            if (check(getA(a), b, c)) count++;
        }

        System.out.println(count);
    }

    private static int getA(int a) {
        if (a <= 85) return 0;
        else if (a <= 102) return 1;
        else if (a <= 135) return 2;
        else return 3;
    }

    private static boolean check(int a, int b, int c) {
        if (c >= map[3][b]) return true;
        else if (c >= map[a][b]) return true;

        return false;
    }
}
