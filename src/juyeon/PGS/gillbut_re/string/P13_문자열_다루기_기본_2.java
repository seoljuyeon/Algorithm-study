package juyeon.PGS.gillbut_re.string;

public class P13_문자열_다루기_기본_2 {
    public static void main(String[] args) {
        P13_문자열_다루기_기본_2 p13 = new P13_문자열_다루기_기본_2();

        System.out.println(p13.solution("a234")); // F
        System.out.println(p13.solution("1234")); // T
    }

    public boolean solution(String s) {
        if (s.length() == 4 || s.length() == 6) {
            try {
                int n = Integer.parseInt(s);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return false;
    }
}
