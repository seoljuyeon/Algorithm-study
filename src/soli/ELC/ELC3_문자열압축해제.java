package soli.ELC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ELC3_문자열압축해제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder(str);

        str = sb.reverse().toString();

        System.out.println(solution(str));

    }

    public static int solution(String str) {
        int idx = 0;
        int len = 0;

        for(int i = 0 ; i < str.length() ; i++) {
            if(Character.isDigit(str.charAt(i))) {
                while(i < str.length() && Character.isDigit(str.charAt(i))) {
                    len++;
                    i++;
                }
                idx = i;
                break;
            }
        }
        for(int i = idx ; i < str.length() ; i++) {
            char c = str.charAt(i);

            if(Character.isDigit(c)) {
                int k = Character.getNumericValue(c);

                len *= k;
                i++;

                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    len++;
                    i++;
                }
            }
        }
        return len;
    }
}

// 11(18(72(7)))