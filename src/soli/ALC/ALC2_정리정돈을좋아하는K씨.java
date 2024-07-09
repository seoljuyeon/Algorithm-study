package soli.ALC;

import java.io.*;
import java.util.*;

public class ALC2_정리정돈을좋아하는K씨 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < n ; i++) {

            a[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            System.out.println(arrayk(a, start, end, k));
        }


    }

    public static int arrayk(int[] a, int start, int end, int k) {

        int[] arr = Arrays.copyOfRange(a, start-1, end);

        Arrays.sort(arr);

        return arr[k-1];
    }
}