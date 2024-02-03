package juyeon.PGS.string;

public class P07_이상한_문자_만들기 {
    public static void main(String[] args) {
        String s = "try hello world";

        String result = solution(s);

        System.out.println(result);
    }

    private static String solution(String s) {
        String answer = "";

        int len = s.length();
        int idx = 0;

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if (c == ' ') {
                answer += c;
                idx = 0;
                continue;
            }

            if (idx % 2 == 0) {
                answer += Character.toUpperCase(c);
                idx++;
            } else {
                answer += Character.toLowerCase(c);
                idx++;
            }
        }

        return answer;
    }

}
