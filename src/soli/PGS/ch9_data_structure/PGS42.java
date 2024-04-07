package soli.PGS.ch9_data_structure;

import java.util.Stack;

public class PGS42 {

    boolean solution(String s){

        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '('){
                stack.add(c);
            } else {
                if(stack.isEmpty()){
                    return answer = false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();

    }

    public static void main(String[] args) {
        PGS42 pgs42 = new PGS42();

        System.out.println(pgs42.solution("()()")); // true
        System.out.println(pgs42.solution("(())()")); // true
        System.out.println(pgs42.solution(")()(")); // false
        System.out.println(pgs42.solution(	"(()(")); // false
    }

}
