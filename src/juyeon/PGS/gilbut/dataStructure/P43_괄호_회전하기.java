package juyeon.PGS.gilbut.dataStructure;

import java.util.*;

public class P43_괄호_회전하기 {
    public static void main(String[] args) {
        System.out.println(solution("[](){}")); // 3
        System.out.println(solution("}]()[{")); // 2
        System.out.println(solution("[)(]")); // 0
        System.out.println(solution("}}}")); // 0
    }

    private static int solution(String s) {
        int answer = 0;

        int len = s.length();

        for (int i = 0; i < len; i++) {
            s = s.substring(1, len) + s.substring(0, 1);

            Stack<Character> st = new Stack<>();

            for (int j = 0; j < len; j++) {
                char c = s.charAt(j);

                if (st.isEmpty()) st.push(c);
                else if (c == ')' && st.peek() == '(') st.pop();
                else if (c == '}' && st.peek() == '{') st.pop();
                else if (c == ']' && st.peek() == '[') st.pop();
                else st.push(c);
            }

            if (st.size() == 0) answer++;
        }

        return answer;
    }
}
