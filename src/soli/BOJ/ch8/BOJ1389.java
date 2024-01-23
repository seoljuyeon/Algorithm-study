package soli.BOJ.ch8;

import doitproblems.ch8_graph.P63_1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1389 implements P63_1389 {

    static int N, M;
    static int[][] D;
    static int[] sum;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 유저의 수 N
        N = Integer.parseInt(st.nextToken());

        // 친구 관계의 수 M
        M = Integer.parseInt(st.nextToken());

        D = new int[N+1][N+1];
        for(int i = 1 ; i <= N ; i++) {
            for(int j = 1 ; j <= N ; j++) {
                if(i == j) {
                    D[i][j] = 0;
                } else {
                    D[i][j] = 100000;
                }
            }
        }

        sum = new int[N+1];

        // 친구 관계 A B
        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            D[A][B] = 1;
            // 친구관계 양방향
            D[B][A] = 1;
        }

        for(int k = 1 ; k <= N ; k++) {
            for(int s = 1 ; s <= N ; s++) {
                for(int e = 1 ; e <= N ; e++) {
                    if(D[s][e] > D[s][k] + D[k][e]) {
                        D[s][e] = D[s][k] + D[k][e];
                    }
                }
            }
        }

        for(int i = 1; i <= N ; i++) {
            for(int j = 1; j <= N ; j++) {
                sum[i] += D[i][j];
            }
        }

        int min = sum[1];
        int min_index = 1;

        for(int i = 1 ; i <= N ;i++) {
            if(sum[i] < min) {
                min = sum[i];
                min_index = i;
            }
        }

        // 최소 케빈베이컨의 수
        System.out.println(min_index);

    }
}
