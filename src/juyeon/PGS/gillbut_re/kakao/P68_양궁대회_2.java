package juyeon.PGS.gillbut_re.kakao;

import java.util.Arrays;

public class P68_양궁대회_2 {
    public static void main(String[] args) {
        P68_양궁대회_2 p68 = new P68_양궁대회_2();

        System.out.println(Arrays.toString(p68.solution(5, new int[]{2,1,1,1,0,0,0,0,0,0,0}))); // [0,2,2,0,1,0,0,0,0,0,0]
//        System.out.println(Arrays.toString(p68.solution(1, new int[]{1,0,0,0,0,0,0,0,0,0,0}))); // [-1]
//        System.out.println(Arrays.toString(p68.solution(9, new int[]{0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1}))); // [1,1,2,0,1,2,2,0,0,0,0]
//        System.out.println(Arrays.toString(p68.solution(10, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3}))); // [1,1,1,1,1,1,1,1,0,0,2]
    }

    private int[] answer = new int[11];
    private int[] temp = new int[11];
    private int gap = -1;

    public int[] solution(int n, int[] info) {
        DFS(n, 0, info);

        if (gap == -1) return new int[]{-1};

        return answer;
    }

    private void DFS(int n, int depth, int[] info) {
        if (depth == n) {
            int diff = computeScore(info);

            // diff == gap 일 때도 answer 업데이트 -> 가장 낮은 점수를 더 많이 맞힌 경우를 return 해주세요. 조건 만족
            if (diff >= gap) {
                gap = diff;
                answer = temp.clone();
            }

            return;
        }

        for (int i = 0; i < 11 && temp[i] <= info[i]; i++) {
            temp[i] += 1;

            DFS(n, depth + 1, info);

            temp[i] -= 1;
        }
    }

    private int computeScore(int[] info) {
        int apeach = 0;
        int ryan = 0;

        for (int i = 0; i < 11; i++) {
            if (info[i] == 0 && temp[i] == 0) continue;

            if (info[i] >= temp[i]) apeach += (10 - i);
            else ryan += (10 - i);
        }

        int diff = ryan - apeach;

        return diff <= 0 ? -1 : diff;
    }
}
