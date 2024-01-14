package soli.ch8;

import doitproblems.ch8_graph.P61_11404;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11404 implements P61_11404 {

    static int N;
    static int M;

    static int[][] D;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 도시개수 n
        N = Integer.parseInt(br.readLine());
        // 버스 개수 m
        M = Integer.parseInt(br.readLine());

        D = new int[N+1][N+1];
        for(int i = 1 ; i <= N ; i++) {
            for(int j = 1; j <= N ; j++) {
                if(i==j) {
                    D[i][j] = 0;
                } else {
                    // Integer.MAX_VALUE 쓰면 덧셈에서 정수값 초과가 나서 'Integer.MIN_VALUE' 로 감싸지게 됨
                    // 오버플로우 넘지 않는 선에서 매우 큰 수 사용하기
                    D[i][j] = 1000000000;
                }
            }
        }

        // 버스 정보 (출발 도시)
        // 시작도시, 도착도시, 필요한 비용 (시작도시 != 도착도시)
        for(int i = 0 ; i < M ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 출발
            int A = Integer.parseInt(st.nextToken());
            // 도착
            int B = Integer.parseInt(st.nextToken());
            // 비용
            int C = Integer.parseInt(st.nextToken());

            // 기존 배열보다 크면 바꾸기
            D[A][B] = Math.min(D[A][B], C);
//            if(D[A][B] > C) {
//                D[A][B] = C;
//            }
        }

        for(int k = 1; k <= N ; k++) {
            for(int s = 1; s <= N ; s++ ) {
                for(int e = 1; e <= N ; e++) {
                    if (D[s][k] < 1000000000 && D[k][e] < 1000000000) {
                        D[s][e] = Math.min(D[s][e], D[s][k] + D[k][e]);
                    }
                }
            }
        }

        for(int i = 1 ; i <= N ; i++) {
            for(int j  = 1 ; j <= N ; j++) {
                if(D[i][j] == 100001) {
                    System.out.print("0 ");
                } else {
                    System.out.print(D[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}