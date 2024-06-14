package juyeon.PGS.gillbut_re.string;

public class P08_문자열_압축_2 {
    public static void main(String[] args) {
        P08_문자열_압축_2 p8 = new P08_문자열_압축_2();

        System.out.println(p8.solution("aabbaccc")); // 7
        System.out.println(p8.solution("ababcdcdababcdcd")); // 9
        System.out.println(p8.solution("abcabcdede")); // 8
        System.out.println(p8.solution("abcabcabcabcdededededede")); // 14
        System.out.println(p8.solution("xababcdcdababcdcd")); // 17
    }

    public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        int len = s.length();

        if (len == 1) return 1;

        for (int i = 1; i <= len / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String str = "";
            String pattern = s.substring(0, i);
            int count = 1;

            for (int j = i; j <= len - i; j += i) {
                if (pattern.equals(s.substring(j, j + i))) count++;
                else {
                    if (count > 1) sb.append(count);
                    sb.append(pattern);

                    pattern = s.substring(j, j + i);
                    count = 1;
                }
            }

            if (count > 1) sb.append(count);
            sb.append(pattern);

            str = sb.toString();

            int rest = len % i;
            answer = Math.min(answer, str.length() + rest);
        }

        return answer;
    }
}
