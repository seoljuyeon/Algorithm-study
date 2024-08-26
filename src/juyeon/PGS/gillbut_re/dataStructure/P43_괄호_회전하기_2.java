package juyeon.PGS.gillbut_re.dataStructure;

import java.util.*;

public class P43_괄호_회전하기_2 {
    public static void main(String[] args) {
        P43_괄호_회전하기_2 p43 = new P43_괄호_회전하기_2();

        System.out.println(p43.solution("[](){}")); // 3
        System.out.println(p43.solution("}]()[{")); // 2
        System.out.println(p43.solution("[)(]")); // 0
        System.out.println(p43.solution("}}}")); // 0
    }

    public int solution(String s) {
        int answer = 0;

        int len = s.length();
        StringBuilder sb;
        String temp;

        for (int i = 1; i <= len; i++) {
            sb = new StringBuilder();

            temp = sb.append(s.substring(i,len)).append(s.substring(0, i)).toString();

            if (check(temp)) answer++;
        }

        return answer;
    }

    private boolean check(String str) {
        Stack<Character> st = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') st.push(c);
            else {
                if (st.size() == 0) return false;
                else {
                    if (st.peek() == '(' && c == ')') st.pop();
                    else if (st.peek() == '{' && c == '}') st.pop();
                    else if (st.peek() == '[' && c == ']') st.pop();
                }
            }
        }

        return st.size() == 0 ? true : false;
    }
}
