package soli.PGS.ch9_data_structure;

import java.util.Stack;

public class PGS42 {

    boolean solution(String s){

        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) == '('){
                stack.add(s.charAt(i));
            } else {
                if(!stack.isEmpty()){
                    stack.pop();
                } else {
                    answer = false;
                }
            }
        }

        return answer;

    }

    public static void main(String[] args) {
        PGS42 pgs42 = new PGS42();

        System.out.println(pgs42.solution("()()")); // true
        System.out.println(pgs42.solution("(())()")); // true
        System.out.println(pgs42.solution(")()(")); // false

    }

}
