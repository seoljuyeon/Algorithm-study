package juyeon.PGS.drill;

public class PGS_큰_수_만들기 {
    public static void main(String[] args) {
        System.out.println(solution("1924", 2)); // 94
        System.out.println(solution("4177252841", 4)); // 775841
    }

    private static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();

        int n = number.length();

        int idx = 0;
        for (int i = 0; i < n - k; i++) {
            int max = 0;
            for (int j = idx; j <= i + k; j++) {
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    idx = j + 1;
                }
            }
            sb.append(max);
        }

        return sb.toString();
    }
}
