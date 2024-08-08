package juyeon.PGS.gillbut_re.hash;

import java.util.*;

public class P34_중복된_문자_제거_2 {
    public static void main(String[] args) {
        P34_중복된_문자_제거_2 p34 = new P34_중복된_문자_제거_2();

        System.out.println(p34.solution("people")); // "peol"
        System.out.println(p34.solution("We are the world")); // "We arthwold"
    }

    public String solution(String my_string) {
        Set<Character> set = new LinkedHashSet<>();

        for (char c : my_string.toCharArray())
            set.add(c);

        StringBuilder sb = new StringBuilder();

        for (char c : set)
            sb.append(c);

        return sb.toString();
    }
}
