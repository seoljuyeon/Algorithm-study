package soli.BOJ.ch8;

import doitproblems.ch8_graph.P62_11403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11403 implements P62_11403 {
    static int N;
    static int[][] D;

    public static void main(String[] args) throws IOException {
        // 가중치 없는 방향 그래프 G
        // 모든 정점(i,j)에 대해서 i -> j 길이가 양수인 경로가 있는지 없는지 구하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정점 개수 N
        N = Integer.parseInt(br.readLine());

        D = new int[N+1][N+1];

        // 인접 행렬
        for(int i = 1 ; i <= N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 1 ; j <= N ; j++) {

                D[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 1 ; k <= N ; k ++) {
            for(int s = 1 ; s <= N ; s++) {
                for(int e = 1 ; e <= N ;e++) {
                    if(D[s][k]+D[k][e] ==2) {
                        D[s][e] = 1;
                    }
                }
            }
        }

        for(int i = 1 ; i <= N ; i ++) {
            for(int j = 1 ; j <= N ; j++) {
                if(D[i][j] == 0) {
                    System.out.print("0 ");
                } else {
                    System.out.print("1 ");
                }
            }
            System.out.println();
        }
    }
}
