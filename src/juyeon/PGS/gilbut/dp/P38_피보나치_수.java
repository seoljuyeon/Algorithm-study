package juyeon.PGS.gilbut.dp;

public class P38_피보나치_수 {
    public static void main(String[] args) {
        System.out.println(solution(3)); // 2
        System.out.println(solution(5)); // 5
    }

    // dp
    private static int solution(int n) {
        return fibo(n);
    }

    private static int fibo(int n) {
        int[] arr = new int[n + 1];

        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = (arr[i - 2] + arr[i - 1]) % 1234567;
        }

        return arr[n];
    }

    // 재귀 -> 시간 초과
//    private static int solution(int n) {
//        return fibo(n) % 1234567;
//    }
//
//    private static int fibo(int n) {
//        if (n < 2) return n;
//        else return fibo(n - 2) + fibo(n - 1);
//    }
}
