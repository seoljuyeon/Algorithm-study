package soli.PGS2.ch2_str;

import soli.PGS.ch2_string.PGS10;

import java.util.Arrays;

public class PGS10_이진변환반복하기 {
    public int[] solution(String s) {

        int zero = 0;
        int cnt = 0;

        while(!s.equals("1")) {

            int slen = s.length();

            s = s.replace("0","");

            zero += slen - s.length();

            s = Integer.toString(s.length(),2);

            cnt++;

        }

        return new int[]{cnt, zero};
    }

    public static void main(String[] args) {
        PGS10 pgs10 = new PGS10();

        System.out.println("Test Case1 : " + Arrays.toString(pgs10.solution("110010101001"	)));
        System.out.println("Test Case2 : " + Arrays.toString(pgs10.solution("01110")));
        System.out.println("Test Case3 : " + Arrays.toString(pgs10.solution("1111111"	)));
    }
}
