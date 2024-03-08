package soli.PGS.ch_array;

import java.util.*;


public class PGS28 {
    public String solution(int[] numbers) {

        String[] strNumbers = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2+s1).compareTo(s1+s2);
            }
        }); // 더 큰 수 리턴 만약에 (s1+s2).compareTo(s2+s2); 하면 오름차순됨

        if (strNumbers[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for(String s : strNumbers) {
            sb.append(s);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        PGS28 pgs28 = new PGS28();

        System.out.println("Test Case : " + pgs28.solution(new int[]{3, 30, 34, 5, 9}));
        System.out.println("Test Case : " + pgs28.solution(new int[]{6, 10, 2}));
    }
}
