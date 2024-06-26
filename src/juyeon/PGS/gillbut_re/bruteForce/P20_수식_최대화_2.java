package juyeon.PGS.gillbut_re.bruteForce;

import java.util.*;

public class P20_수식_최대화_2 {
    public static void main(String[] args) {
        P20_수식_최대화_2 p20 = new P20_수식_최대화_2();

        System.out.println(p20.solution("100-200*300-500+20")); // 60420
        System.out.println(p20.solution("50*6-3*2")); // 300
    }

    public long solution(String expression) {
        long answer = Long.MIN_VALUE;

        // 순열 시러서 하드코딩 했습니다
        String op[][] = { { "+", "-", "*" }, { "+", "*", "-" }, { "-", "*", "+" },
                { "-", "+", "*" }, { "*", "-", "+" }, { "*", "+", "-" } };

        List<String> list = new ArrayList<>();

        int idx = 0;

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                list.add(expression.substring(idx, i));
                list.add(expression.charAt(i) + "");
                idx = i + 1;
            }
        }

        list.add(expression.substring(idx));

        for (int i = 0; i < 6; i++) {
            List<String> temp = new ArrayList<>(list);

            for (int k = 0; k < 3; k++) {
                for (int j = 0; j < temp.size(); j++) {
                    if (op[i][k].equals(temp.get(j))) {
                        String v = calc(temp.get(j - 1), temp.get(j), temp.get(j + 1));

                        temp.set(j - 1, v);

                        temp.remove(j);
                        temp.remove(j);

                        j--;
                    }
                }
            }

            answer = Math.max(answer, Math.abs(Long.parseLong(temp.get(0))));
        }

        return answer;
    }

    private String calc(String str1, String op, String str2) {
        long x = Long.parseLong(str1);
        long y = Long.parseLong(str2);

        if (op.equals("+")) return x + y + "";
        else if (op.equals("-")) return x - y + "";
        else return x * y + "";
    }
}
