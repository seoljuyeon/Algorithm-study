package soli.PGS.ch11_kakao;

import java.util.*;

public class PGS71 {

    static int[] dx = {-1, 1,0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] gBoard;

    public int solution(int[][] board, int[] aloc, int[] bloc) {



        gBoard = board;
        return 0;
    }

    public void dfs(int[] aloc, int[] bloc, int count) {

        int ax = aloc[0];
        int ay = aloc[1];
        int bx = bloc[0];
        int by = bloc[1];

        for(int i = 0 ; i < 4 ; i++) {
            int nax = ax + dx[i];
            int nay = ay + dy[i];
            int nbx = bx + dx[i];
            int nby = by + dy[i];

            if (nax < 0 || nay < 0 || nax >= gBoard.length || nay >= gBoard[0].length || gBoard[nax][nay] == 0 ||nbx < 0 || nby < 0 || nbx >= gBoard.length || nby >= gBoard[0].length || gBoard[nbx][nby] == 0) {
                continue;
            }
        }
    }


    }

    public static void main(String[] args) {
        PGS71 sol = new PGS71();
        int[][] board1 = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int[] aloc1 = {1, 0};
        int[] bloc1 = {1, 2};
        System.out.println(sol.solution(board1, aloc1, bloc1));  // Output: 5

        int[][] board2 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[] aloc2 = {1, 0};
        int[] bloc2 = {1, 2};
        System.out.println(sol.solution(board2, aloc2, bloc2));  // Output: 4

        int[][] board3 = {{1, 1, 1, 1, 1}};
        int[] aloc3 = {0, 0};
        int[] bloc3 = {0, 4};
        System.out.println(sol.solution(board3, aloc3, bloc3));  // Output: 4

        int[][] board4 = {{1}};
        int[] aloc4 = {0, 0};
        int[] bloc4 = {0, 0};
        System.out.println(sol.solution(board4, aloc4, bloc4));  // Output: 0
    }
}
