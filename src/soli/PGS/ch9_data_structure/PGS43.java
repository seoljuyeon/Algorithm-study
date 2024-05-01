package soli.PGS.ch9_data_structure;

import java.util.Stack;

public class PGS43 {
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            if(isValid(s.substring(i) + s.substring(0, i))) {
                answer++;
            }
        }

    return answer;

    }

    private boolean isValid (String s){
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.add(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char p = stack.pop();
                if((c == ')' && p != '(') || (c == ']' && p != '[') || (c == '}' && p != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        PGS43 pgs43 = new PGS43();
        System.out.println(pgs43.solution("[](){}")); // 3
        System.out.println(pgs43.solution("}]()[{")); // 2
        System.out.println(pgs43.solution("[)(]")); // 0
        System.out.println(pgs43.solution("}}}")); // 0
    }
}
