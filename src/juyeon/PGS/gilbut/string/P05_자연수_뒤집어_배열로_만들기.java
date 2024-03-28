package juyeon.PGS.gilbut.string;

public class P05_자연수_뒤집어_배열로_만들기 {
    public static void main(String[] args) {
        long n = 12345;

        int[] result = solution(n);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }

    private static int[] solution(long n) {
        String str = String.valueOf(n);
        int len = str.length();

        int[] answer = new int[len];

        for (int i = len; i > 0; i--) {
            answer[len - i] = (int)str.charAt(i - 1) - '0';
        }


        return answer;
    }

    private static int[] solution2(long n) {
        String str = "" + n;
        int[] answer = new int[str.length()];

        int i = 0;

        while (n > 0) {
            answer[i] = (int) (n % 10);
            n /= 10;
            i++;
        }

        return answer;
    }

    private static int[] solution3(long n) {
        return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
    }
}
