package soli.PGS2.ch5_sort;

import java.util.Arrays;

public class PGS26_문자열내림차순으로배치하기 {

    public String solution(String s) {

        char[] c = s.toCharArray();

        Arrays.sort(c);

        return new StringBuilder(new String(c)).reverse().toString();
    }

    public static void main(String[] args) {

        PGS26_문자열내림차순으로배치하기 pgs26_문자열내림차순으로배치하기 = new PGS26_문자열내림차순으로배치하기();

        System.out.println("Test Case1 :" + pgs26_문자열내림차순으로배치하기.solution("adsaeECdsdEZ"));
    }
}
