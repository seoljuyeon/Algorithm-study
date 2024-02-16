package juyeon.PGS.string;

public class P14_신규_아이디_추천 {
    public static void main(String[] args) {
        String testCase1 = "...!@BaT#*..y.abcdefghijklm"; // "bat.y.abcdefghi"
        String testCase2 = "z-+.^."; // "z--"
        String testCase3 = "=.="; // "aaa"
        String testCase4 = "123_.def"; // "123_.def"
        String testCase5 = "abcdefghijklmn.p"; // "abcdefghijklmn"

        System.out.println("testCase1 : " + solution(testCase1));
        System.out.println("testCase2 : " + solution(testCase2));
        System.out.println("testCase3 : " + solution(testCase3));
        System.out.println("testCase4 : " + solution(testCase4));
        System.out.println("testCase5 : " + solution(testCase5));
    }

    private static String solution(String new_id) {
        String answer = new_id.toLowerCase();

        answer = answer.replaceAll("[^a-z0-9-_.]", "");

        while (answer.contains("..")) {
            answer = answer.replace("..", ".");
        }

//        answer = answer.replaceAll("[.]{2,}", ".");

        answer = answer.replaceAll("^[.]|[.]$", "");

        if (answer.length() == 0) answer = "a";

        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
        }

        answer = answer.replaceAll("[.]$", "");

        int len = answer.length();

        if (len <= 2) {
            char c = answer.charAt(len - 1);
            while (answer.length() < 3) {
                answer += c;
            }
        }

        return answer;
    }
}
