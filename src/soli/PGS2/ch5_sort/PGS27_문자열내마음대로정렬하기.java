package soli.PGS2.ch5_sort;

import soli.PGS.ch_array.PGS27;

import java.util.Arrays;
import java.util.Comparator;

public class PGS27_문자열내마음대로정렬하기 {

    public String[] solution(String[] strings, int n) {

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(n) > o2.charAt(n)) return 1;
                else if(o1.charAt(n) < o2.charAt(n)) return -1;
                else return o1.compareTo(o2);
            }
        });

        return strings;
    }
    public static void main(String[] args) {

    PGS27_문자열내마음대로정렬하기 pgs27 = new PGS27_문자열내마음대로정렬하기();

        System.out.println("Test Case : " + Arrays.toString(pgs27.solution(new String[]{"sun", "bed", "car"}, 1)) );
        System.out.println("Test Case : " + Arrays.toString(pgs27.solution(new String[]{"abce", "abcd", "cdx"}, 2)) );

    }
}
