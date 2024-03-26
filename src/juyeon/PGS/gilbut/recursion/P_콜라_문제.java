package juyeon.PGS.gilbut.recursion;

public class P_콜라_문제 {
    public static void main(String[] args) {
        System.out.println(solution(2, 1, 20)); // 19
        System.out.println(solution(3, 1, 20)); // 9
        System.out.println(solution(3, 2, 20)); // 36
    }

    // 빈 병 a 개 갖다 주면 콜라 b 병 줌, 빈 병 n 개 있으면 콜라가 몇 병?

    private static int solution(int a, int b, int n) {
        int count = 0;

        while (n >= a) {
            count += n / a * b;
            n = n / a * b + n % a;
        }

        return count;
    }
}
