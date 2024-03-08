package soli.PGS.ch_array;

import java.util.Arrays;
import java.util.Comparator;

public class PGS27 {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.charAt(n) > s2.charAt(n)) {
                    return 1;
                } else if(s1.charAt(n) < s2.charAt(n)) {
                    return -1;
                } else {
                    return s1.compareTo(s2);
                }
            }
        });

        return strings;
    }

    public static void main(String[] args) {
        PGS27 pgs27 = new PGS27();

        System.out.println("Test Case : " + Arrays.toString(pgs27.solution(new String[]{"sun", "bed", "car"}, 1)) );
        System.out.println("Test Case : " + Arrays.toString(pgs27.solution(new String[]{"abce", "abcd", "cdx"}, 2)) );
    }
}
