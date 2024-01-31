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

    public static void main(String[] args) {
        PGS5 pgs5 = new PGS5();

        System.out.println("Test case : " + pgs5.solution(12345));  // [5,4,3,2,1]
    }
}
