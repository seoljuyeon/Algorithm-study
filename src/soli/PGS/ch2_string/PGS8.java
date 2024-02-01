package soli.PGS.ch2_string;
// https://school.programmers.co.kr/learn/courses/30/lessons/60057
public class PGS8 {
    public int solution(String s) {

        int min = s.length();

        for(int i = 1 ; i <= s.length() / 2 ; i++) {
            StringBuilder sb = new StringBuilder();
            String str = s.substring(0, i);
            int count = 1;

            // 자른 문자열은 s.length 다 검사 필요
            for(int j = i ; j <= s.length() ; j+=i ) {
                String next;

                if(i + j > s.length()) {
                    next = s.substring(j);
                } else {
                    next = s.substring(j, i+j);
                }

                if(str.equals(next)) {
                    count++;
                } else {
                    if(count > 1) {
                        sb.append(count);
                    }
                    sb.append(str);
                    // 다음 문자열 검사
                    str = next;
                    // count 초기화
                    count = 1;
                }
            }
            if(count > 1) {
                sb.append(count);
            }
            sb.append(str);

            min = Math.min(min, sb.length());

        }

        return min;
    }

    public static void main(String[] args) {
        PGS8 pgs8 = new PGS8();

        System.out.println("Test Case1 : " + pgs8.solution("aabbaccc"));
        System.out.println("Test Case2 : " + pgs8.solution("ababcdcdababcdcd"));
        System.out.println("Test Case3 : " + pgs8.solution("abcabcdede"));
        System.out.println("Test Case5 : " + pgs8.solution("abcabcabcabcdededededede"));
        System.out.println("Test Case6 : " + pgs8.solution("xababcdcdababcdcd"));

    }
}
