package juyeon.PGS.gillbut_re.string;

public class P06_시저_암호_2 {
    public static void main(String[] args) {
        P06_시저_암호_2 p6 = new P06_시저_암호_2();

        System.out.println(p6.solution("AB", 1)); // "BC"
        System.out.println(p6.solution("z", 1)); // "a"
        System.out.println(p6.solution("a B z", 4)); // "e F d"
    }

    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ' ') {
            } else {
                if (Character.isUpperCase(c)) {
                    c = (char) (((c + n - 'A') % 26) + 'A');
                } else {
                    c = (char) (((c + n - 'a') % 26) + 'a');
                }
            }

            sb.append(c);
        }

        return sb.toString();
    }
}
