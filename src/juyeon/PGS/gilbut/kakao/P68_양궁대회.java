package juyeon.PGS.gilbut.kakao;

import java.util.Arrays;

public class P68_양궁대회 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(5, new int[]{2,1,1,1,0,0,0,0,0,0,0}))); // [0,2,2,0,1,0,0,0,0,0,0]
//        System.out.println(Arrays.toString(solution(1, new int[]{1,0,0,0,0,0,0,0,0,0,0}))); // [-1]
        System.out.println(Arrays.toString(solution(9, new int[]{0,0,1,2,0,1,1,1,1,1,1}))); // [1,1,2,0,1,2,2,0,0,0,0]
        System.out.println(Arrays.toString(solution(10, new int[]{0,0,0,0,0,0,0,0,3,4,3}))); // [1,1,1,1,1,1,1,1,0,0,2]
    }

    static private int[] answer = new int[11];
    static private int[] temp = new int[11];
    static private int gap = -1;

    private static int[] solution(int n, int[] info) {
        DFS(n, info, 0);

        if (gap == -1) return new int[]{-1};

        return answer;
    }

    private static void DFS(int n, int[] info, int depth) {
        if (depth == n) {
            int diff = computeScore(info);

            if (diff >= gap) {
                gap = diff;
                answer = temp.clone();
            }

            return;
        }

        for(int i = 0; i < info.length && temp[i] <= info[i]; i++) {
            temp[i] += 1;

            DFS(n, info, depth + 1);

            temp[i] -= 1;
        }
    }

    private static int computeScore(int[] info) {
        int apeach = 0;
        int ryan = 0;

        for (int i = 0; i < info.length; i++) {
            if (info[i] == 0 && temp[i] == 0) continue;

            if (info[i] >= temp[i]) apeach += (10 - i);
            else ryan += (10 - i);
        }

        int diff = ryan - apeach;

        return diff <= 0 ? -1 : diff;
    }
}
