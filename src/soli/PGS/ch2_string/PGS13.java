package soli.PGS.ch2_string;

public class PGS13 {
    public static void main(String[] args) {
        PGS13 pgs13 = new PGS13();
        System.out.println("Test Case1 : " + pgs13.solution("a234"));
        System.out.println("Test Case1 : " + pgs13.solution("1234"));
    }

    public boolean solution(String s) {

        if(s.length() != 4 && s.length() != 6) {
            return false;
        }
        if(s.matches("^[0-9]+")) {
            return true;
        }
        return false;

    }
}
