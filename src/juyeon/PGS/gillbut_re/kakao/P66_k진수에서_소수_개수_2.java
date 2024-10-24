package juyeon.PGS.gillbut_re.kakao;

public class P66_k진수에서_소수_개수_2 {
    public static void main(String[] args) {
        P66_k진수에서_소수_개수_2 p66 = new P66_k진수에서_소수_개수_2();

        System.out.println(p66.solution(437674, 3)); // 3
        System.out.println(p66.solution(110011, 10)); // 2
    }

    public int solution(int n, int k) {
        String num = Integer.toString(n, k);
        int count = 0;

        String[] arr = num.split("0");

        for (String str : arr) {
            if (str.isEmpty()) continue;

            long i = Long.parseLong(str);
            if (isPrime(i)) count++;
        }

        return count;
    }

    private boolean isPrime(long n) {
        if (n == 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
