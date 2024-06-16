package soli.PGS2.ch2_str;

import soli.PGS.ch2_string.PGS5;

public class PGS5_자연수뒤집어배열로만들기 {
    public int[] solution(long n) {

        String str = Long.toString(n);

        int[] answer = new int[str.length()];

        int num = str.length() - 1;

        while(num >= 0) {
            for(int i = 0 ; i < str.length() ; i++) {
                answer[i] = str.charAt(num) - '0';
                num--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        PGS5_자연수뒤집어배열로만들기 pgs5 = new PGS5_자연수뒤집어배열로만들기();

        System.out.println("Test case : " + pgs5.solution(12345));  // [5,4,3,2,1]
    }
}
