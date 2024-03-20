package soli.practice.dp;

import java.util.*;
import java.io.*;

public class BOJ2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] num = new int[N+1];
        int[] dp = new int[N+1];

        for(int i = 1 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            num[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = num[1];
        if(N >= 2) {
            dp[2] = num[1] + num[2];
        }
        for(int i = 3 ; i <= N ; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3]+num[i-1])+num[i];
        }

        System.out.println(dp[N]);
    }

}
