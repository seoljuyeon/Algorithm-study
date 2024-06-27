package soli.PGS2.ch4_exhaustive_search;

import java.util.ArrayList;

public class PGS20_수식최대화 {


    static long answer = 0;

    public long solution(String expression) {

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

        for(int i = 0 ; i < 3 ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                operator[priority] = op[i];
                dfs(numbers, operators, operator, visited, priority+1);
                visited[i] = false;
            }
        }

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

}
