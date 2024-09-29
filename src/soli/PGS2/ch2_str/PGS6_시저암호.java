package soli.PGS2.ch2_str;

import soli.PGS.ch2_string.PGS6;

public class PGS6_시저암호 {
    public String solution(String s, int n) {

        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            if(c != ' '){
                if(c >= 'a' && c <= 'z'){
                    sb.append((char)((c - 'a'+ n) % 26 + 'a'));
                } else if(c >= 'A' && c <= 'Z') {
                    sb.append((char)((c - 'A'+ n) % 26 + 'A'));
                }
            } else {
                sb.append(' ');
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        PGS6_시저암호 pgs6 = new PGS6_시저암호();

        System.out.println("Test case 1: " + pgs6.solution("AB", 1)); // "BC"
        System.out.println("Test case 2: " + pgs6.solution("z", 1)); // "a"
        System.out.println("Test case 3: " + pgs6.solution("a B z", 4)); // "e F d"
    }
}
