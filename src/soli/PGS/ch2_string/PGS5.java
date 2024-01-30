package soli.PGS.ch2_string;

public class PGS5 {
    public int[] solution(long n) {

        String str = Long.toString(n);
        int[] answer = new int[str.length()];

        int idx = 0;
        int i = str.length() -1;

        while(idx < str.length() && idx >= 0) {
            answer[idx] = str.charAt(i) - '0';
            idx++;
            i--;
        }

        return answer;
    }
}
