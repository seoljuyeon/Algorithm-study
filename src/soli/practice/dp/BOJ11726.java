package soli.practice.dp;

import java.io.*;

public class BOJ11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] bp = new int[N+1];

        bp[1] = 1;
        if(N >= 2) {
            bp[2] = 2;
        }

        for(int i = 3 ; i <= N ; i++) {
            bp[i] = (bp[i-2] + bp[i-1]) % 10007;
        }
        System.out.println(bp[N]);
//        System.out.println(bp[N]%10007); 실패
    }
}
