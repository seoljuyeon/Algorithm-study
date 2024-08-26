package soli.PGS2.ch9_data_structure;

import java.util.Stack;

public class PGS42_올바른괄호 {
    boolean solution(String s){

        Stack<Character> stack = new Stack();
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) == '(') {
                stack.add(s.charAt(i));
            } else {
                if(stack.isEmpty()) return false;
                else stack.pop();
            }
        }

        return stack.isEmpty() ? true : false;

    }
}
