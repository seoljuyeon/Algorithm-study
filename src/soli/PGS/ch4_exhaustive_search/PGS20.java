package soli.PGS.ch4_exhaustive_search;

import java.util.*;

class PGS20 {

    static long answer = 0;

    public static long solution(String expression) {

        ArrayList<Long> numbers = new ArrayList<>();
        ArrayList<Character> operators = new ArrayList<>();
        String num = "";

        for(char c : expression.toCharArray()) {
            if(Character.isDigit(c)) {
                num += c;
            } else {
                numbers.add(Long.parseLong(num));
                num = "";
                operators.add(c);
            }
        }
        numbers.add(Long.parseLong(num));

        char[] operator = new char[]{'+','-','*'};
        boolean[] visited = new boolean[3];

        dfs(numbers, operators, operator, visited, 0);

        return answer;

    }

    private static void dfs(ArrayList<Long> numbers, ArrayList<Character> operators, char[] operator, boolean[] visited, int priority){

        char[] op = {'+', '-', '*'};

        // 연산자에 우선순위 부여하는 과정
        for(int i = 0 ; i < 3 ; i++) {
            // 연산자 방문 체크
            if(!visited[i]) {
                visited[i] = true;
                operator[priority] = op[i];
                dfs(numbers, operators, operator, visited, priority+1);
                visited[i] = false;
            }
        }

        // 모든 우선순위가 부여되었을 때
        if(priority == 3) {
            ArrayList<Long> tmpNum = new ArrayList<>(numbers);
            ArrayList<Character> tmpOperator = new ArrayList<>(operators);

            for(char o : operator) {
                for(int i = 0 ; i < tmpOperator.size() ; i++) {
                    if(tmpOperator.get(i) == o) {
                        long result = calculate(tmpNum.remove(i), tmpNum.remove(i), o);
                        tmpNum.add(i, result);
                        tmpOperator.remove(i);
                        i--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(tmpNum.get(0)));
            return;
        }

    }

    private static long calculate(long a, long b, char o) {
        switch(o) {
            case '+' :
                return a + b;
            case '-' :
                return a - b;
            case '*' :
                return a * b;
        }
        return 0;
    }

    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        System.out.println(solution(expression)); // 60420
    }
}