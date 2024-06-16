package soli.PGS2.ch2_str;

import soli.PGS.ch2_string.PGS11;

public class PGS11_뮨자열내p와y의개수 {

    boolean solution(String s) {

        s = s.toLowerCase();
        int countP = 0;
        int countY = 0;

        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) == 'p') {
                countP++;
            }
            else if(s.charAt(i) == 'y') {
                countY++;
            }
        }

        return countP == countY ? true : false;

    }


    public static void main(String[] args) {
        PGS11_뮨자열내p와y의개수 pgs11 = new PGS11_뮨자열내p와y의개수();

        System.out.println("Test Case1 " + pgs11.solution("pPoooyY"));
        System.out.println("Test Case1 " + pgs11.solution("Pyy"));

    }
}
