package juyeon.PGS.gilbut.sort;

import java.util.Arrays;

public class P26_문자열_내림차순_배치 {
    public static void main(String[] args) {
        System.out.println(solution("Zbcdefg")); // "gfedcbZ"
    }

    private static String solution(String s) {
        char[] chars = s.toCharArray();

        Arrays.sort(chars);

        return new StringBuilder(new String(chars)).reverse().toString();
    }
}
