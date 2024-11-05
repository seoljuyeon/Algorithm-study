package juyeon.PGS.drill.lv0;

public class PSG_간단한_식_계산하기 {
    public static void main(String[] args) {
        System.out.println(solution("43 + 12"));
        System.out.println(solution("0 - 7777"));
        System.out.println(solution("40000 * 40000"));
    }

    private static int solution(String binomial) {
        // ba-bo

//        StringBuilder a = new StringBuilder();
//        StringBuilder op = new StringBuilder();
//        StringBuilder b = new StringBuilder();
//
//        for (char c : binomial.toCharArray()) {
//            if (c == ' ') continue;
//
//            if (c == '+' || c == '-' || c == '*') op.append(c);
//            else if (op.toString().length() == 0) a.append(c);
//            else b.append(c);
//        }
//
//        int num_a = Integer.parseInt(a.toString());
//        int num_b = Integer.parseInt(b.toString());
//        String operator = op.toString();
//
//        if (operator.equals("+")) return num_a + num_b;
//        else if (operator.equals("-")) return num_a - num_b;
//        else return num_a * num_b;

        String[] str = binomial.split(" ");

        int a = Integer.parseInt(str[0]);
        String op = str[1];
        int b = Integer.parseInt(str[2]);

        if (op.equals("+")) return a + b;
        else if (op.equals("-")) return a - b;
        else return a * b;
    }
}
