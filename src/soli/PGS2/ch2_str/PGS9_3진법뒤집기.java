package soli.PGS2.ch2_str;

import soli.PGS.ch2_string.PGS9;

public class PGS9_3진법뒤집기 {
    public int solution(int n) {

        StringBuffer sb = new StringBuffer(Integer.toString(n, 3));

        String reverse = sb.reverse().toString();


        return Integer.parseInt(reverse, 3);
    }

    public static void main(String[] args) {
        PGS9 pgs9 = new PGS9();
        System.out.println("Test Case1 : " + pgs9.solution(45));
        System.out.println("Test Case2 : " + pgs9.solution(125));
    }
}
