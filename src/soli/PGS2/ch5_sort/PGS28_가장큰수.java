package soli.PGS2.ch5_sort;

import soli.PGS.ch_array.PGS28;

import java.util.Arrays;
import java.util.Comparator;

public class PGS28_가장큰수 {

    public String solution(int[] numbers) {

        String[] num = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            num[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(num, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }


        });
        if (num[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for(String s : num) {
            sb.append(s);
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        PGS28_가장큰수 pgs28 = new PGS28_가장큰수();

        System.out.println("Test Case : " + pgs28.solution(new int[]{3, 30, 34, 5, 9}));
        System.out.println("Test Case : " + pgs28.solution(new int[]{6, 10, 2}));
    }
}
