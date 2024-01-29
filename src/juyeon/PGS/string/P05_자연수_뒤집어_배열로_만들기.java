package juyeon.PGS.string;

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
}
