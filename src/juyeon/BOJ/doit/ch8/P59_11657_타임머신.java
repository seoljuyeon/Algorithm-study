package juyeon.BOJ.doit.ch8;

import doitproblems.ch8_graph.P59_11657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Bus {
    int s;
    int e;
    int w;

    public Bus(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }
}

public class P59_11657_타임머신 implements P59_11657 {

    static int N, M;
    static int INF = Integer.MAX_VALUE;
    static Bus[] arr;
    static long[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new Bus[M + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            arr[i] = new Bus(A, B, C);
        }

        distance = new long[N + 1];

        Arrays.fill(distance, INF);

        StringBuilder sb = new StringBuilder();

        if (findCycle()) {
            sb.append(-1 + "\n");
        } else {
            for (int i = 2; i <= N; i++) {
                sb.append(distance[i] == INF ? -1 : distance[i]).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean findCycle() {
        boolean cycle = false;
        distance[1] = 0;

        for (int j = 1; j <= N; j++) {
            for (int i = 1; i <= M; i++) {
                int s = arr[i].s;
                int e = arr[i].e;
                int w = arr[i].w;

                if (distance[s] != INF && distance[s] + w < distance[e]) {
                    distance[e] = distance[s] + w;

                    if (j == N) cycle = true;
                }
            }
        }

        return cycle;
    }
}