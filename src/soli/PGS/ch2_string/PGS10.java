package soli.PGS.ch2_string;

import java.util.Arrays;

public class PGS10 {

    public int[] solution(String s) {

        int count = 0 ; // 이진변환 횟수
        int num = 0;  // 제거되는 0의 길이
        int[] answer = new int[2];

        while(!s.equals("1")) {
            int before = s.length(); // 바뀌기 전 길이
            s = s.replace("0","");
            int after = s.length(); // 바뀌고 나서 길이
            num += before - after;

            s = Integer.toBinaryString(after);
            count++;
        }

        answer[0] = count;
        answer[1] = num;

        return answer;
    }

    public static void main(String[] args) {
        PGS10 pgs10 = new PGS10();

        System.out.println("Test Case1 : " + Arrays.toString(pgs10.solution("110010101001"	)));
        System.out.println("Test Case2 : " + Arrays.toString(pgs10.solution("01110")));
        System.out.println("Test Case3 : " + Arrays.toString(pgs10.solution("1111111"	)));
    }
}
