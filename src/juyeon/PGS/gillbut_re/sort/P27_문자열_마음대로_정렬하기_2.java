package juyeon.PGS.gillbut_re.sort;

import java.util.Arrays;

public class P27_문자열_마음대로_정렬하기_2 {
    public static void main(String[] args) {
        P27_문자열_마음대로_정렬하기_2 p27 = new P27_문자열_마음대로_정렬하기_2();

        System.out.println(Arrays.toString(p27.solution(new String[] {"sun", "bed", "car"}, 1))); // ["car", "bed", "sun"]
        System.out.println(Arrays.toString(p27.solution(new String[] {"abce", "abcd", "cdx"}, 2))); // ["abcd", "abce", "cdx"]
    }

    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, ((o1, o2) -> {
            char c1 = o1.charAt(n);
            char c2 = o2.charAt(n);

            if (c1 == c2) return o1.compareTo(o2);
            else return c1 - c2;
        }));

        return strings;
    }
}
