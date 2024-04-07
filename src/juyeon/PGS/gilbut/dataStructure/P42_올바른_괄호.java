package juyeon.PGS.gilbut.dataStructure;

import java.util.*;

public class P42_올바른_괄호 {
    public static void main(String[] args) {
        System.out.println(solution("()()")); // t
        System.out.println(solution("(())()")); // t
        System.out.println(solution(")()(")); // f
    }

    private static boolean solution(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') st.push(c);
            else if (c == ')') {
                if (st.size() != 0) st.pop();
                else return false;
            }
        }

        return st.isEmpty();
    }
}
