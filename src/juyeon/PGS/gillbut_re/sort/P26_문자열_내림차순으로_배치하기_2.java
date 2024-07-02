package juyeon.PGS.gillbut_re.sort;

import java.util.*;

public class P26_문자열_내림차순으로_배치하기_2 {
    public static void main(String[] args) {
        P26_문자열_내림차순으로_배치하기_2 p26 = new P26_문자열_내림차순으로_배치하기_2();

        System.out.println(p26.solution("Zbcdefg")); // "gfedcbZ"
    }

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        char[] str = s.toCharArray();

        Arrays.sort(str);

        for (char c : str) {
            sb.append(c);
        }

        return sb.reverse().toString();
    }
}
