package soli.ELC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ELC1_목표량 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[] c = Integer.toString(N).toCharArray();

        int i = c.length - 2;
        while (i >= 0 && c[i] >= c[i + 1]) {
            i--;
        }

        if(i >= 0) {
            int j = c.length - i;
            while(c[j] <= c[i]) {
                j--;
            }

            swap(c, i, j);
        }

        reverse(c, i + 1, c.length - 1);

        System.out.println(Integer.parseInt(new String(c)));

    }

    private static void swap(char[] c, int i, int j) {

        char temp = c[i];

        c[i] = c[j];

        c[j] = temp;

    }

    private static void reverse(char[] c, int start, int end) {

        while (start < end) {

            swap(c, start, end);

            start++;

            end--;

        }

    }

}
