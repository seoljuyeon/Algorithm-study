package soli.PGS2.ch3_recursion;

import soli.PGS.ch3_recursion.PGS16;

import java.util.ArrayList;
import java.util.Arrays;

public class PGS16_하노이의탑 {

    private static ArrayList<int[]> arr = new ArrayList<>();

    public int[][] solution (int n) {
        move(n, 1, 2, 3);

        int[][] answer = new int[arr.size()][2];
        for(int i = 0 ; i < arr.size() ; i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }

    private static void move(int n, int start, int mid, int end) {
        if(n==1) {
            arr.add(new int[]{start, end});
            return;
        }
        move(n-1, start, end, mid);
        arr.add(new int[]{start, end});
        move(n-1, mid, start, end);
    }

    public static void main(String[] args) {
        PGS16_하노이의탑 pgs16 = new PGS16_하노이의탑();
        int[][] solution = pgs16.solution(3);

        // 2차원 배열을 반복하여 각 하위 배열을 문자열로 변환 후 출력
        for (int[] move : solution) {
            System.out.print(Arrays.toString(move) + " ");
        }
    }
}
