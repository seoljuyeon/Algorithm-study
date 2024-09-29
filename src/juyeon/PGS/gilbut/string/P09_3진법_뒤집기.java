package juyeon.PGS.gilbut.string;

public class P09_3진법_뒤집기 {
    public static void main(String[] args) {
        int testCase1 = 45; // 7
        int testCase2 = 125; // 229

        System.out.println("testCase1, solution1 : " + solution(testCase1));
        System.out.println("testCase1 , solution2: " + solution2(testCase1));
        System.out.println("testCase1 , solution3: " + solution3(testCase1));

        System.out.println();

        System.out.println("testCase2 , solution1: " + solution(testCase2));
        System.out.println("testCase2 , solution2: " + solution2(testCase2));
        System.out.println("testCase2 , solution3: " + solution3(testCase2));
    }

    private static int solution(int n) {
        int answer = 0;

        String str = Integer.toString(n, 3);

        StringBuilder sb = new StringBuilder();
        str = sb.append(str).reverse().toString();

        answer = Integer.parseInt(str, 3);

        return answer;
    }

    private static int solution2(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append(n%3);
            n /= 3;
        }

        String str = sb.toString();

        return Integer.parseInt(str, 3);
    }

    private static int solution3(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append(n%3);
            n /= 3;
        }

        String str = sb.reverse().toString();

        int k = 0;

        for (int i = 0; i < str.length(); i++) {
            k += Math.pow(3, i) * (str.charAt(i) - '0');
        }

        return k;
    }

}
