package juyeon.PGS.gillbut_re.string;

public class P11_문자열_py_개수_2 {
    public static void main(String[] args) {
        P11_문자열_py_개수_2 p11 = new P11_문자열_py_개수_2();

        System.out.println(p11.solution("pPoooyY")); // T
        System.out.println(p11.solution("Pyy")); // F
    }

    boolean solution(String s) {
        int p = 0, y = 0;

        s = s.toLowerCase();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'p') p++;
            else if (c == 'y') y++;
        }

        return p == y;
    }
}
