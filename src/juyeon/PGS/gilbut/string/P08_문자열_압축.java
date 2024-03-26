package juyeon.PGS.gilbut.string;

public class P08_문자열_압축 {
    public static void main(String[] args) {
        String s = "aabbaccc"; // 7
//        String s = "ababcdcdababcdcd"; // 9
//        String s = "abcabcdede"; // 8
//        String s = "abcabcabcabcdededededede"; // 14
//        String s = "xababcdcdababcdcd"; // 17

        int result = solution(s);

        System.out.println(result);
    }

    private static int solution(String s) {
        int answer = Integer.MAX_VALUE;

        int len = s.length();

        if (len == 1) return 1;

        for (int i = 1; i <= len / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String str = "";
            String pattern = s.substring(0, i);
            int count = 1;

            for (int j = i; j <= len - i; j += i) {
                if (pattern.equals(s.substring(j, j + i))) {
                    count++;
                    continue;
                } else {
                    if (count > 1) {
                        sb.append(count);
                    }
                    sb.append(pattern);

                    pattern = s.substring(j, j + i);
                    count = 1;

                }
            }

            if (count > 1) {
                sb.append(count);
            }
            sb.append(pattern);

            str = sb.toString();

            int rest = len % i;
            answer = Math.min(answer, str.length() + rest);
        }



        return answer;
    }
}
