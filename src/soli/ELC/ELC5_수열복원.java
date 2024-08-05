package soli.ELC;

import java.io.*;
import java.util.*;

public class ELC5_수열복원 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[(int)Math.pow(2, n)];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < (int)Math.pow(2,n) ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 입력 받은 배열 정렬
        Arrays.sort(arr);

        // 원래 수열을 저장할 배열
        int[] original = new int[n];

        // arr 배열의 앞에서부터 n 개의 원소를 뽑아서 만드는 합이 arr[(1 << n) - 1] 일 때, 이를 찾기
        for (int i = 1; i < n ; i++) {
            int sum = 0;
            int count = 0;
            for (int j = 2 ; j < n ; j++) {
                if ((i & (1 << j)) != 0) { // j번째 원소를 포함하는 경우
                    sum += arr[j];
                    original[count++] = arr[j];
                }
            }
            if (count == n && sum == arr[n-1]) {
                break;
            }
        }

        // 결과 출력
        Arrays.sort(original); // 오름차순 정렬
        for (int i = 0; i < n; i++) {
            System.out.print(original[i] + " ");
        }
    }
}
