package soli.ELC;

import java.util.Scanner;
import java.util.Arrays;

public class ELC7_계기판조작하기_정답 {
    public static void main(String[] args) {
        // 입력을 받기 위한 Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // N과 K를 입력받음
        String N = scanner.next();
        int K = scanner.nextInt();
        scanner.close();

        // 숫자의 사용 여부를 추적하기 위한 배열과 카운터 초기화
        boolean[] digit = new boolean[10];
        int cnt = 0;

        // K가 10인 경우, 모든 0부터 9까지의 숫자가 포함된 가장 작은 수는 1023456789
        if (K == 10) {
            System.out.println("1023456789");
        }
        // K가 9인 경우, 0을 제외한 1부터 9까지의 숫자가 포함된 가장 작은 수는 102345678
        else if (K == 9) {
            System.out.println("102345678");
        }
        // 그 외의 경우
        else {
            // 원하는 조건을 만족하는 수를 찾을 때까지 반복
            while (cnt != K) {
                // digit 배열을 false로 초기화
                Arrays.fill(digit, false);
                cnt = 0;

                // N을 1 증가시킴
                N = Integer.toString(Integer.parseInt(N) + 1);

                // N의 각 자릿수를 확인하여 digit 배열에 표시
                for (int i = 0; i < N.length(); i++) {
                    digit[N.charAt(i) - '0'] = true;
                }

                // 사용된 서로 다른 숫자의 개수를 셈
                for (int i = 0; i < 10; i++) {
                    if (digit[i]) {
                        cnt++;
                    }
                }
            }
            // 조건을 만족하는 수 출력
            System.out.println(N);
        }
    }
}
