package juyeon.PGS.string;

public class P11_문자열_py_개수 {
    public static void main(String[] args) {
        String testCase1 = "pPoooyY"; // T
        String testCase2 = "Pyy"; // F

        System.out.println("testCase1 : " + solution(testCase1));
        System.out.println("testCase2 : " + solution(testCase2));
    }

    private static boolean solution(String s) {
        int p = 0;
        int y = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'p' || c == 'P') p++;
            if (c == 'y' || c == 'Y') y++;
        }

        return p == y;
    }
}
