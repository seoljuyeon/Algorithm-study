package juyeon.PGS.gillbut_re.dataStructure;

import java.util.*;

public class P42_올바른_괄호_2 {
    public static void main(String[] args) {
        P42_올바른_괄호_2 p42 = new P42_올바른_괄호_2();

        System.out.println(p42.solution("()()")); // t
        System.out.println(p42.solution("(())()")); // t
        System.out.println(p42.solution(")()(")); // f
    }

    boolean solution(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') st.push(c);
            else {
                if (st.size() == 0) return false;
                else st.pop();
            }
        }

        return st.size() == 0 ? true : false;
    }
}
