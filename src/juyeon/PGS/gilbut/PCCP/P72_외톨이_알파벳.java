package juyeon.PGS.gilbut.PCCP;

import java.util.*;

public class P72_외톨이_알파벳 {
    public static void main(String[] args) {
        System.out.println(solution("edeaaabbccd")); // "de"
        System.out.println(solution("eeddee")); // "e"
        System.out.println(solution("string")); // "N"
        System.out.println(solution("zbzbz")); // "bz"
    }

    private static String solution(String input_string) {
        String answer = "";

        Set<Character> set = new HashSet<>();
        Set<Character> tree = new TreeSet<>();

        char temp = ' ';

        for (char c : input_string.toCharArray()) {
            if (c != temp) {
                if (set.contains(c)) {
                    tree.add(c);
                }
                set.add(c);
                temp = c;
            }
        }

        for (char c : tree) {
            answer += c;
        }

        return answer == "" ? "N" : answer;
    }
}
