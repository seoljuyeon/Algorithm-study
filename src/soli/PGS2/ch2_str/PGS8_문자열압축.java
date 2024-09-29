package soli.PGS2.ch2_str;

import soli.PGS.ch2_string.PGS8;

public class PGS8_문자열압축 {
    public int solution(String s) {
        int answer = 0;
        return answer;
    }

    public static void main(String[] args) {
        PGS8_문자열압축 pgs8 = new PGS8_문자열압축();

        System.out.println("Test Case1 : " + pgs8.solution("aabbaccc"));
        System.out.println("Test Case2 : " + pgs8.solution("ababcdcdababcdcd"));
        System.out.println("Test Case3 : " + pgs8.solution("abcabcdede"));
        System.out.println("Test Case5 : " + pgs8.solution("abcabcabcabcdededededede"));
        System.out.println("Test Case6 : " + pgs8.solution("xababcdcdababcdcd"));

    }
}
