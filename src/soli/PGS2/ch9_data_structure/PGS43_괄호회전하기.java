package soli.PGS2.ch9_data_structure;

import java.util.Stack;

public class PGS43_괄호회전하기 {
    public int solution(String s) {

        int answer = 0;

        for(int i = 0 ; i < s.length() ; i++) {
            if(isCorrect(s.substring(i)+ s.substring(0, i))){
                answer++;
            }
        }

        return answer;
    }

    private boolean isCorrect(String newString) {

        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < newString.length() ; i++) {

            char c = newString.charAt(i);

            if(c == '(' || c == '[' || c == '{') {
                stack.add(c);
            } else {
                if(stack.isEmpty()) return false;

                char pop = stack.pop();
                if((c==')' && pop != '(')|| (c==']' && pop != '[') && (c=='}' && c != '{')) return false;
            }
        }
        return stack.isEmpty(); // 결과 유효한지 확인
    }

    public static void main(String[] args) {
        PGS43_괄호회전하기 pgs43 = new PGS43_괄호회전하기();
        System.out.println(pgs43.solution("[](){}")); // 3
        System.out.println(pgs43.solution("}]()[{")); // 2
        System.out.println(pgs43.solution("[)(]")); // 0
        System.out.println(pgs43.solution("}}}")); // 0
    }
}
