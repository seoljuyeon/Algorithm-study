package juyeon.PGS.drill.lv2;

import java.util.*;

public class PGS_올바른_괄호 {
    public static void main(String[] args) {
        System.out.println(solution("()()")); // T
        System.out.println(solution(")()(")); // F
    }

    private static boolean solution(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push('(');
            } else {
                if (st.size() != 0) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
}
