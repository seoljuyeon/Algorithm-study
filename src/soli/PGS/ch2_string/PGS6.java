package soli.PGS.ch2_string;

public class PGS6 {
    public String solution(String s, int n) {

        char[] c = new char[s.length()];

        for(int i = 0 ; i < s.length() ; i++) {
            char current = s.charAt(i);
            if(current != ' ') {
                if(current >= 'a' && current <= 'z') {
                    c[i] = (char)('a' + (current - 'a' + n) % 26);
                } else if(current >= 'A' && current <= 'Z') {
                    c[i] = (char)('A' + (current - 'A' + n) % 26);
                }
            } else {
                c[i] = ' ';
            }
        }

        return new String(c);
    }

    public static void main(String[] args) {
        PGS6 pgs6 = new PGS6();

        System.out.println("Test case 1: " + pgs6.solution("AB", 1)); // "BC"
        System.out.println("Test case 2: " + pgs6.solution("z", 1)); // "a"
        System.out.println("Test case 3: " + pgs6.solution("a B z", 4)); // "e F d"
    }
}
