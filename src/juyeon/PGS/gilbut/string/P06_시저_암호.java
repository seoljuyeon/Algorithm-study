package juyeon.PGS.gilbut.string;

public class P06_시저_암호 {
    public static void main(String[] args) {
//        String s = "AB";
//        int n = 1;

//        "BC"

//        String s = "z";
//        int n = 1;

//        "a"

        String s = "a B z";
        int n = 4;

//        "e F d"

        String result = solution(s, n);

        System.out.println(result);
    }

    private static String solution(String s, int n) {
        String answer = "";

        for (char c : s.toCharArray()) {
            if (c == ' ') {
            }
            else {
                if (c <= 90) {
                    c += n;
                    if (c > 90) c -= 26;
                } else {
                    c += n;
                    if (c > 122) c -= 26;
                }
            }
            answer += c;
        }

        return answer;
    }
}
