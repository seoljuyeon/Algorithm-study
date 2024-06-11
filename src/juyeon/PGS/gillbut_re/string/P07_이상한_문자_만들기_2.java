package juyeon.PGS.gillbut_re.string;

public class P07_이상한_문자_만들기_2 {
    public static void main(String[] args) {
        P07_이상한_문자_만들기_2 p7 = new P07_이상한_문자_만들기_2();

        System.out.println(p7.solution("try hello world")); // "TrY HeLlO WoRlD"
    }

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        int idx = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') {
                sb.append(c);
                idx = 0;
            }
            else {
                if (idx % 2 == 0) {
                    c = Character.toUpperCase(c);
                    idx++;
                } else {
                    c = Character.toLowerCase(c);
                    idx++;
                }

                sb.append(c);
            }
        }

        return sb.toString();
    }
}
