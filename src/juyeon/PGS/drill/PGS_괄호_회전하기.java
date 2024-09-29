package juyeon.PGS.drill;

import java.util.*;

public class PGS_괄호_회전하기 {
    public static void main(String[] args) {
        System.out.println(solution("[](){}")); // 3
    }

    private static int solution(String s) {
        int count = 0;

        int n = s.length();

        for (int i = 0; i < n; i++) {
            String str = s.substring(i, n) + s.substring(0, i);

            Stack<Character> st = new Stack<>();

            for (int j = 0; j < n; j++) {

                char c = str.charAt(j);

                if (st.isEmpty()) st.push(c);
                else if (c == ')' && st.peek() == '(') st.pop();
                else if (c == '}' && st.peek() == '{') st.pop();
                else if (c == ']' && st.peek() == '[') st.pop();
                else st.push(c);
            }

            if (st.isEmpty()) count++;
        }

        return count;
    }
}
