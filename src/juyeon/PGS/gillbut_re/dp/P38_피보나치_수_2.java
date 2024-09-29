package juyeon.PGS.gillbut_re.dp;

public class P38_피보나치_수_2 {
    public static void main(String[] args) {
        P38_피보나치_수_2 p38 = new P38_피보나치_수_2();

        System.out.println(p38.solution(3)); // 2
        System.out.println(p38.solution(5)); // 5
    }

    public int solution(int n) {
        int answer = 0;

        int f0 = 0;
        int f1 = 1;

        for (int i = 2; i <= n; i++) {
            answer = (f0 + f1) % 1234567;

            f0 = f1;
            f1 = answer;
        }

        return answer;
    }
}
