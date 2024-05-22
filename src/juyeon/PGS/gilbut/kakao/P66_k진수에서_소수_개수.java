package juyeon.PGS.gilbut.kakao;

public class P66_k진수에서_소수_개수 {
    public static void main(String[] args) {
        System.out.println(solution(437674, 3)); // 3
        System.out.println(solution(110011, 10)); // 2
    }

    private static int solution(int n, int k) {
        String str = Integer.toString(n, k);

        String[] arr = str.split("0");

        int count = 0;

        for (String s : arr) {
            if (s.length() == 0) continue;

            long num = Long.parseLong(s);
            if (isPrime(num)) count++;
        }

        return count;
    }

    private static boolean isPrime(long num) {
        if (num == 1) {
            return false;
        }
        if (num == 2 || num == 3) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
