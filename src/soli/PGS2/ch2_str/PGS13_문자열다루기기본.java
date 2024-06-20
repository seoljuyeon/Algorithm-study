package soli.PGS2.ch2_str;

import soli.PGS.ch2_string.PGS13;

public class PGS13_문자열다루기기본 {

    public boolean solution(String s) {

        if (s.length() != 4 && s.length() != 6) {
            return false;
        }
        if (s.matches("[0-9]+")){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PGS13_문자열다루기기본 pgs13 = new PGS13_문자열다루기기본();
        System.out.println("Test Case1 : " + pgs13.solution("a234"));
        System.out.println("Test Case1 : " + pgs13.solution("1234"));
    }
}
