package juyeon.PGS.gillbut_re.string;

public class P09_3진법_뒤집기_2 {
    public static void main(String[] args) {
        P09_3진법_뒤집기_2 p9 = new P09_3진법_뒤집기_2();

        System.out.println(p9.solution(45)); // 7
        System.out.println(p9.solution(125)); // 229
    }

    public int solution(int n) {
        StringBuilder sb = new StringBuilder();

        String str = Integer.toString(n, 3);

        str = sb.append(str).reverse().toString();

        return Integer.parseInt(str, 3);
    }
}
