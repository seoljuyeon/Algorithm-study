package juyeon.PGS.gilbut.string;

public class P12_숫자_문자열과_영단어 {
    public static void main(String[] args) {
        String testCase1 = "one4seveneight"; // 1478
        String testCase2 = "23four5six7"; // 234567
        String testCase3 = "2three45sixseven"; // 234567
        String testCase4 = "123"; // 123

        System.out.println("testCase1 : " + solution(testCase1));
        System.out.println("testCase2 : " + solution(testCase2));
        System.out.println("testCase3 : " + solution(testCase3));
        System.out.println("testCase4 : " + solution(testCase4));
    }

    private static int solution(String s) {
        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < 10; i++) {
            if (s.contains(num[i])) {
                s = s.replace(num[i], Integer.toString(i));
            }
        }

        return Integer.parseInt(s);
    }
}
