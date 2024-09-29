package juyeon.ELC;

import java.util.*;
import java.io.*;

public class Day2_정리_정돈을_좋아하는_K씨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int e = 0; e < m; e++) {
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] temp = Arrays.copyOfRange(arr, i - 1, j);

            Arrays.sort(temp);

            System.out.println(temp[k - 1]);
        }
    }
}

//8 3
//1 7 6 8 1 6 4 5
//1 5 3
//2 6 2
//4 8 3

//6
//6
//5