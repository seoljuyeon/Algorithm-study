package juyeon.PGS.gillbut_re.implementation;

import java.util.*;

public class P63_큰_수_만들기_2 {
    public static void main(String[] args) {
        P63_큰_수_만들기_2 p63 = new P63_큰_수_만들기_2();

        System.out.println(p63.solution("1924", 2)); // "94"
        System.out.println(p63.solution("1231234", 3)); // "3234"
        System.out.println(p63.solution("4177252841", 4)); // "775841"
    }

    public String solution(String number, int k) {
        Stack<Character> st = new Stack<>();

        for (char c : number.toCharArray()) {
            while (!st.isEmpty() && st.peek() < c && k > 0) {
                st.pop();
                k--;
            }
            st.push(c);
        }

        while (k > 0) {
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        for (char c : st) {
            sb.append(c);
        }

        return sb.toString();
    }
}
