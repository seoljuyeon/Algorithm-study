package soli.practice.dp;

import java.io.*;
import java.util.*;

// 프로그래밍 대회에서 배우는 알고리즘 문제해결전략 책 p.215
// 동적 알고리즘
public class dp1 {
    static int n;
    static int[][] board = new int[100][100];
    static int[][] cache = new int[100][100];



    public static boolean jump(int y, int x) {
        if(y >= n || x >= n) return false;
        if(y == n-1 && x == n-1) return true;

        // 만약에 아직 방문 안했으면 cache[y][x] == 1 로 초기화
        if(cache[y][x] != -1) return cache[y][x] == 1;
        int jumpSize = board[y][x];

        boolean canJump = jump(y + jumpSize, x) || jump(y, x+ jumpSize);
        cache[y][x] = canJump ? 1 : 0;  // 만약에 가능하면 1 아니면 0
        return canJump;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < 100 ; i++) {
            for(int j = 0 ; j < 100 ; j++) {
                cache[i][j] = -1;   // -1로 초기화
            }
        }
        System.out.println(jump(0, 0) ? "YES" : "NO");
    }
}


//7
//2 5 1 6 1 4 1
//6 1 1 2 2 9 3
//7 2 3 2 1 3 1
//1 1 3 1 7 1 2
//4 1 2 3 4 1 2
//3 3 1 2 3 4 1
//1 5 2 9 4 7 0
////답 : YES
//
//7
//2 5 1 6 1 4 1
//6 1 1 2 2 9 3
//7 2 3 2 1 3 1
//1 1 3 1 7 1 2
//4 1 2 3 4 1 3
//3 3 1 2 3 4 1
//1 5 2 9 4 7 0
////답 : NO