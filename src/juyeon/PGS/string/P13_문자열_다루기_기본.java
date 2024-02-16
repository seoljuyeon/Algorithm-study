package juyeon.PGS.string;

public class P13_문자열_다루기_기본 {
    public static void main(String[] args) {
        String testCase1 = "a234"; // F
        String testCase2 = "1234"; // T

        System.out.println("testCase1 : " + solution(testCase1));
        System.out.println("testCase2 : " + solution(testCase2));
    }

    private static boolean solution(String s) {
        if (s.length() != 4 && s.length() != 6) return false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') return false;
        }

        return true;
    }
}
